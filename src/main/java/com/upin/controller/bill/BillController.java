package com.upin.controller.bill;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.upin.entity.bill.Bill;
import com.upin.entity.order.Order;
import com.upin.entity.wxuser.WXUser;
import com.upin.service.bill.BillService;
import com.upin.service.goods.GoodsService;
import com.upin.service.order.OrderService;
import com.upin.service.wxuser.WXUserService;
import com.common.constant.Const;
import com.common.utils.DateUtil;
import com.common.utils.GeneratID;

@Controller
@RequestMapping("/bill")
public class BillController {
	@Autowired
	BillService billService;
	@Autowired
	OrderService orderService;
	@Autowired
	WXUserService wxUserService;
//	@Autowired
//	AccessTokenService accessTokenService;   
	@Autowired
	GoodsService goodsService;   

//	/**
//	 * 新增空白账单
//	 * 金额为0
//	 * 状态未支付
//	 * @param request
//	 * @param response
//	 */
//	@RequestMapping(value = "/insertBill")
//	public void insertBill(HttpServletRequest request, HttpServletResponse response) {
//		response.setContentType("text/json;charset=UTF-8");
//		/* 设置字符集为'UTF-8' */
//		response.setCharacterEncoding("UTF-8");
//		JSONObject res = new JSONObject();
//
//		// 获取前台数据
//		String userId = request.getParameter("userId");// 用户userId
//		String orderId = request.getParameter("orderId");// 订单id
//		String type = request.getParameter("type");//fk,tx,tk
//		
//		// 添加bill
//		Bill bill = new Bill();
//		if (userId != null && userId != "") {
//			String id = GeneratID.getGeneratID();
//			bill.setId(id);
//			if(type == "fk") {
//				bill.setUserId(userId);
//				bill.setToUserId("");
//				bill.setOrderId(orderId);
//			}else if(type == "tx"){
//				bill.setToUserId(userId);
//				bill.setUserId("");
//			}else if(type == "tk") {
//				bill.setToUserId(userId);
//				bill.setUserId("");
//			}
//			// 无金额账单--未支付
//			bill.setState("0");
//			bill.setMoney("0");//初始账单默认金额为0
//			
//			bill.setCreateTime(DateUtil.getStringDate());
//			bill.setUpdateTime(DateUtil.getStringDate());
//			billService.insert(bill);
//		}
//		// 存储相应信息
//		res.put("billId", bill.getId());
//		res.put("code", "1");
//		try {
//			response.getWriter().print(res);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}// 返回响应
//	}
//
//	@RequestMapping(value = "/getBillList")
//	public void getBillList(HttpServletRequest request, HttpServletResponse response) {
//		response.setContentType("text/json;charset=UTF-8");
//		/* 设置字符集为'UTF-8' */
//		response.setCharacterEncoding("UTF-8");
//		JSONObject res = new JSONObject();
//		
//		String userId = request.getParameter("userId");
//		String pageNum = request.getParameter("pageNum");
//		// 查询条件
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("userId", userId);
//		map.put("pageNum", pageNum);
//		map.put("pageSize", "10");
//		// 查询结果集
//		try {
//			List<Map<String, String>> billList = billService.getBillList(map);
//			res.put("billList", billList);
//			res.put("code", Const.SUCCEED);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			response.getWriter().print(res);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}// 返回响应
//	}
//
//	/**
//	 * 根据账单id查询账单
//	 * @param request
//	 * @param response
//	 * @throws Exception
//	 */
//	@RequestMapping(value = "/getBillDetail")
//	public void getBillDetail(HttpServletRequest request, HttpServletResponse response) {
//		response.setContentType("text/json;charset=UTF-8");
//		/* 设置字符集为'UTF-8' */
//		response.setCharacterEncoding("UTF-8");
//		JSONObject res = new JSONObject();
//
//		String billId = request.getParameter("billId");
//
//		// 查询条件
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("billId", billId);
//		List<Map<String, String>> bill = billService.getOneById(map);
//		res.put("billDetail", bill.get(0));
//		try {
//			response.getWriter().print(res);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}// 返回响应
//	}
//	
//	
//	/**
//	 * 更新账单
//	 * 
//	 * @param request
//	 * @param response
//	 * @throws Exception
//	 */
//	@RequestMapping(value = "/updateBillById")
//	public void updateBillByBillId(HttpServletRequest request, HttpServletResponse response) {
//		response.setContentType("text/json;charset=UTF-8");
//		/* 设置字符集为'UTF-8' */
//		response.setCharacterEncoding("UTF-8");
//		//返回数据
//		JSONObject res = new JSONObject();
//		// 获取前台数据
//		String billId = request.getParameter("billId");// 账单id
//		String type = request.getParameter("type");// 账单类型
//		String money = request.getParameter("money");// 付款金额
//		
//		//根据账单billId查询userId
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("billId", billId);
//		List<Map<String, String>> billList = billService.getOneById(map);
//		String userId = billList.get(0).get("userId");// 用户userId
//		String toUserId = billList.get(0).get("toUserId");// 用户toUserId
//		
//		Map<String, String> userMap = new HashMap<String, String>();
//		// 根据userId查询已有余额
//		userMap.put("userId", userId);
//		WXUser wxUser = wxUserService.getOneById(wxUserId);
//		// 已有余额
//		double wxUserMoney = Double.parseDouble(wxUser.getMoney());
//		
//		WXUser toUser = userService.getOneById(toUserId);
//		double toUserMoney = Double.parseDouble(toUser.getMoney());
//
//		if (billId != null && billId != "") {
//			//更新账单
//			Bill bill = billService.getOne(billId);
//			bill.setMoney(money);
//			bill.setState("1");
//			bill.setUpdateTime(DateUtil.getStringDate());
//			billService.update(bill);
//			//更新账户余额
//			if(type == "fk") {
//				toUserMoney += Double.parseDouble(money);
//				toUser.setMoney(String.valueOf(toUserMoney));
//				toUser.setUpdateTime(DateUtil.getStringDate());
//				userService.update(toUser);
//			}else if(type == "tx") {
//				userMoney += Double.parseDouble(money);
//				user.setMoney(String.valueOf(userMoney));
//				user.setUpdateTime(DateUtil.getStringDate());
//				userService.update(user);
//			}else if(type == "tk") {
//				userMoney += Double.parseDouble(money);
//				user.setMoney(String.valueOf(userMoney));
//				user.setUpdateTime(DateUtil.getStringDate());
//				userService.update(user);
//				
//				toUserMoney -= Double.parseDouble(money);
//				toUser.setMoney(String.valueOf(toUserMoney));
//				user.setUpdateTime(DateUtil.getStringDate());
//				userService.update(toUser);
//			}
//			// 存储相应信息
//			res.put("code", Const.SUCCEED);
//		}
//		try {
//			response.getWriter().print(res);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}// 返回响应
//	}
//	
//	public String sendTemolateMessage(String touser ,String form_id, String receiverImfo, String receiverPlace, String orderDetail, String orderRemark)
//    {
//		String template_id = "r2W6-C4S9udmovfVi-ncmv6yQDyTAvHdDpgOK1r4w2k";
//    	String result = null;
//		try {
////			result = SendMessageUtil.sendWXTemplateMessage(	touser, 
////					template_id, //模板Id
////					form_id, //
////					SendMessageUtil.getSendOrderPayNoticeData(	"新订单通知", 
////							receiverImfo, 
////							receiverPlace, 
////							orderDetail,
////							orderRemark),getToken());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//    	return result;
//    }

}