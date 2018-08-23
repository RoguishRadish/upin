package com.upin.controller.goods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.common.constant.Const;
import com.upin.constants.Constants;
import com.upin.constants.MsgConst;
import com.upin.service.goods.GoodsService;

@Controller  
@RequestMapping("/goods")  
public class GoodsController {
	private static Logger logger = LoggerFactory.getLogger(GoodsController.class);
	
	@Autowired
	GoodsService goodsService;
	
	/**
	 * getGoodsList
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/getGoodsList")
	public void getGoodsList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		/* 设置字符集为'UTF-8' */
		response.setCharacterEncoding("UTF-8");
		JSONObject res = new JSONObject();
		//前台数据
		String type = request.getParameter("type");
		String pageNum = request.getParameter("pageNum");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		if (type.equals(Constants.Goods.GOODS_TYPE_ALL)) {
			map.put("pageNum", pageNum);
			map.put("pageSize", Constants.Goods.PAGE_SIZE);
		}
		try {
			List<Map<String, Object>> goodsList = goodsService.getGoodsList(map);
			res.put("code", Const.SUCCEED);
			res.put("goodsList", goodsList);
			logger.info(Constants.Goods.GOODS_TYPE_VALUE.get(type) + MsgConst.QUERY_SUCCEED, goodsList);
		} catch (Exception e) {
			logger.error(Constants.Goods.GOODS_TYPE_VALUE.get(type) + MsgConst.QUERY_FAILED, e);
			res.put("code", Const.FAIL);
		}
		
		try {
			response.getWriter().print(res);// 返回响应
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * getDetail
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getDetail")
	public void getDetail(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/json;charset=UTF-8"); 
		/*设置字符集为'UTF-8'*/
		response.setCharacterEncoding("UTF-8");
		JSONObject res = new JSONObject();
		
		String goodsId = request.getParameter("goodsId");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("goodsId", goodsId);
		List<Map<String, String>> goodsList = goodsService.getOneById(map);
		String picId[] = goodsList.get(0).get("picIds").split(",");
		List<String> picIdList = new ArrayList<String>();
		for (int i = 0; i < picId.length; i++) {
			picIdList.add(picId[i]);
		}
		Map<String, Object> picMap = new HashMap<String, Object>();
		picMap.put("picIds", picIdList);
		List<Map<String, String>> picUrlList = goodsService.getPicUrls(picMap);
		//存储相应信息
		res.put("code", Const.SUCCEED);
		res.put("resData", goodsList.get(0));
		res.put("picUrls", picUrlList);
		
    	try {
 			response.getWriter().print(res);
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}//返回响应
	}
}
