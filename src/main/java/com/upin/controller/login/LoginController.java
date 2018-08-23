package com.upin.controller.login;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.common.constant.Const;
import com.common.utils.GeneratID;
import com.common.wxcategory.WxCategory;
import com.upin.constants.MsgConst;
import com.upin.entity.wxuser.WXUser;
import com.upin.service.wxuser.WXUserService;

@Controller
@RequestMapping("/")
public class LoginController {

	private static Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	WXUserService wxUserService;

	/**
	 * @return
	 */
	@RequestMapping(value = "/index")
	public void index() {
		logger.info("index");
	}

	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/wxLogin")
	public void wxLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		/* 设置字符集为'UTF-8' */
		response.setCharacterEncoding("UTF-8");
		//返回数据
		JSONObject res = new JSONObject();
		// 获取前台页面的code
		String code = request.getParameter("js_code");
		String nickName = request.getParameter("nickName");// 昵称
		String avatarUrl = request.getParameter("avatarUrl");// 头像
		String sex = request.getParameter("sex");
		// 根据code获取微信openId
		String openId = WxCategory.getOpenId(code);
		if (StringUtils.isNotBlank(openId)) {
			// 根据openId查询用户
			WXUser wxUser = wxUserService.getOneByOpenId(openId);
			wxUser.setNickName(nickName);
			wxUser.setUserPic(avatarUrl);
			wxUser.setLastLoginTime(new Date());
			if (StringUtils.isNotBlank(wxUser.getId())) {
				// 有此openId的用户，更新用户数据
				wxUserService.update(wxUser);
				logger.info(wxUser.getId() + "," + nickName + MsgConst.UPDATE_SUCCEED);
			} else {
				// 无此openId的用户，新建用户数据
				String wxUserId = GeneratID.getGeneratID().toString();
				wxUser.setId(wxUserId);
				wxUser.setOpenId(openId);
				wxUser.setSex(sex);
				wxUser.setMoney("0");
				wxUser.setFirstLoginTime(new Date());
				wxUserService.insert(wxUser);
				logger.info(wxUser.getId() + "," + nickName + MsgConst.ADD_SUCCEED);
			}
			// 存储相应信息
			res.put("code", Const.SUCCEED);
			res.put("wxUser", wxUser);
			logger.info(wxUser.getId() + "," + nickName + MsgConst.LOGIN_SUCCEED);
		} else {
			// 存储相应信息
			res.put("code", Const.FAIL);
			logger.info(nickName + MsgConst.LOGIN_FAILED);
		}
		try {
			response.getWriter().print(res);// 返回响应
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
