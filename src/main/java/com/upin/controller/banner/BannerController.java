package com.upin.controller.banner;

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
import com.common.utils.GeneratID;
import com.upin.constants.Constants;
import com.upin.entity.address.Address;
import com.upin.service.address.AddressService;

@Controller  
@RequestMapping("/banner")  
public class BannerController {
	private static Logger logger = LoggerFactory.getLogger(BannerController.class);
	
	@Autowired
	AddressService addressService;
	
	@RequestMapping(value = "/getAddressList")
	public void getAddressList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		/* 设置字符集为'UTF-8' */
		response.setCharacterEncoding("UTF-8");
		
		String pageNum = request.getParameter("pageNum");
		
		JSONObject res = new JSONObject();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("pageSize", Constants.Address.PAGE_SIZE);
			map.put("pageNum", pageNum);
			List<Map<String, Object>> addressList = addressService.getAddressList(map);
			
			res.put("code", Const.SUCCEED);
			res.put("addressList", addressList);
			logger.info("查询收货地址成功", addressList);
		} catch (Exception e) {
			logger.error("查询收货地址失败", e);
			res.put("code", Const.FAIL);
		}
		
		try {
			response.getWriter().print(res);// 返回响应
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getAddressDetail")
	public void getBillDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		/* 设置字符集为'UTF-8' */
		response.setCharacterEncoding("UTF-8");
		
		String addressId = request.getParameter("addressId");
		
		JSONObject res = new JSONObject();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("addressId", addressId);
			List<Map<String, Object>> addressDetail = addressService.getAddressDetail(map);
			
			res.put("code", Const.SUCCEED);
			if (addressDetail.size() > 0) {
				res.put("addressDetail", addressDetail.get(0));
				logger.info("查询账单详情成功", addressDetail.get(0));
			} else {
				res.put("addressDetail", null);
				logger.info("查询成功,无此账单");
			}
		} catch (Exception e) {
			logger.error("查询订单详情失败", e);
			res.put("code", Const.FAIL);
		}
		
		try {
			response.getWriter().print(res);// 返回响应
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value = "/createAddress")
	public void createAddress(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		/* 设置字符集为'UTF-8' */
		response.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String addressId = request.getParameter("");
		String name = request.getParameter("");
		String phone = request.getParameter("");
		String address = request.getParameter("");
		String isone = request.getParameter("");
		
		JSONObject res = new JSONObject();
		try {
			Address addr = new Address();
			addr.setUserId(userId);
			addr.setName(name);
			addr.setPhone(phone);
			addr.setAddress(address);
			addr.setIsone(isone);
			if(addressId != null && addressId != "") {
				addr.setId(addressId);
				addressService.update(addr);
				res.put("code", Const.SUCCEED);
			}else {
				addr.setId(GeneratID.getGeneratID());
				addressService.insert(addr);
				res.put("code", Const.SUCCEED);
			}
		} catch (Exception e) {
			logger.error("", e);
			res.put("code", Const.FAIL);
		}
		
		try {
			response.getWriter().print(res);// 返回响应
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
