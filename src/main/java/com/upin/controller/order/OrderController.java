package com.upin.controller.order;

import java.io.IOException;
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
import com.common.utils.DateUtil;
import com.common.utils.GeneratID;
import com.upin.entity.order.Order;
import com.upin.constants.Constants;
import com.upin.constants.MsgConst;
import com.upin.service.order.OrderService;

@Controller  
@RequestMapping("/order")  
public class OrderController {
	private static Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = "/getOrderList")
	public void getOrderList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		/* 设置字符集为'UTF-8' */
		response.setCharacterEncoding("UTF-8");
		JSONObject res = new JSONObject();
		
		String orderState = request.getParameter("orderState");
		String pageNum = request.getParameter("pageNum");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderState", orderState);
		map.put("pageSize", Constants.Order.PAGE_SIZE);
		map.put("pageNum", pageNum);
		try {
			List<Map<String, Object>> orderList = orderService.getOrderList(map);
			res.put("code", Const.SUCCEED);
			res.put("orderList", orderList);
			logger.info("orderList" + MsgConst.QUERY_SUCCEED, orderList);
		} catch (Exception e) {
			logger.error("orderList" + MsgConst.QUERY_FAILED, e);
			res.put("code", Const.FAIL);
		}
		try {
			response.getWriter().print(res);// 返回响应
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getOrderDetail")
	public void getOrderDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		/* 设置字符集为'UTF-8' */
		response.setCharacterEncoding("UTF-8");
		JSONObject res = new JSONObject();
		
		String orderId = request.getParameter("orderId");
		
		try {
			Order order = orderService.getOneById(orderId);
			if (order != null) {
				res.put("code", Const.SUCCEED);
				res.put("orderDetail", order);
				logger.info("orderDetail" + MsgConst.QUERY_SUCCEED, order);
			}else {
				res.put("code", Const.SUCCEED);
				res.put("orderDetail", null);
				logger.info("orderDetail" + MsgConst.QUERY_SUCCEED);
			}
		} catch (Exception e) {
			logger.error("orderDetail" + MsgConst.QUERY_FAILED, e);
			res.put("code", Const.FAIL);
		}
		
		try {
			response.getWriter().print(res);// 返回响应
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/createOrder")
	public void createOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		/* 设置字符集为'UTF-8' */
		response.setCharacterEncoding("UTF-8");
		JSONObject res = new JSONObject();

		String userId = request.getParameter("userId");
		String orderId = request.getParameter("orderId");
		String goodsId = request.getParameter("goodsId");
		String goodsName = request.getParameter("goodsName");
		String goodsNum = request.getParameter("goodsNum");
		String addressId = request.getParameter("addressId");
		String userName = request.getParameter("userName");
		String address = request.getParameter("address");
		String status = request.getParameter("status");
		
		Order order = new Order();
		order.setUserId(userId);
		order.setGoodsId(goodsId);
		order.setGoodsName(goodsName);
		order.setGoodsNum(goodsNum);
		order.setAddressId(addressId);
		order.setUserName(userName);
		order.setAddress(address);
		order.setStatus(status);
		if(orderId != null && orderId != "") {
			order.setId(orderId);
			order.setUpdateTime(DateUtil.getStringDate());
			orderService.update(order);
			res.put("code", Const.SUCCEED);
		}else {
			orderId = GeneratID.getGeneratID();
			order.setId(orderId);
			order.setCreateTime(DateUtil.getStringDate());
			order.setUpdateTime(DateUtil.getStringDate());
			orderService.insert(order);
			res.put("code", Const.SUCCEED);
		}
		order = orderService.getOneById(orderId);
		res.put("order", order);
		try {
			response.getWriter().print(res);// 返回响应
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
