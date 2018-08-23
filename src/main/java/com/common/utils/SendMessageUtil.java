package com.common.utils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;

public class SendMessageUtil {
	
	private static Logger logger = Logger.getLogger(SendMessageUtil.class);
	//读取配置

	
	
	
	/**
	 * 通过前端接口wxCommon(安全验证，不包含ACCESS_TOKEN)，发送模版消息
	 * 
	 * @param openId
	 * @param templateId
	 * @param url
	 * @param topColor
	 * @param data
	 * @return
	 */
	public static String sendWXTemplateMessage(String touser, String template_id, String form_id, JSONObject data,String token) {

//		WxTemplate t = new WxTemplate();
//		//t.setPage(page);
//		t.setTouser(touser);
//		t.setForm_id(form_id);
//		// 模板ID
//		t.setTemplate_id(template_id);
//		t.setData(data);
//		
		Map<String,String>map =new HashMap<String, String>();
		map.put("touser",touser);
		map.put("form_id",form_id);
		map.put("template_id",template_id);
		map.put("data", data.toString());
		
		String result = sendPost("https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token="+token, map);
		System.out.println("发送模板消息返回结果－"+result);
		
		return result;
	}
	
	//-----------------------------
	//以下为获取未支付订单的微信消息模板参数内容
	
	/**"sendOrderPayNotice"
	 * 订单未支付通知
	 */
	public static JSONObject getSendOrderPayNoticeData(String title, String receiverImfo, String receiverPlace, String orderDetail, String orderRemark)
	{
		Map<String, TemplateData> m = new HashMap<String, TemplateData>();
		// 标题
//		TemplateData first = new TemplateData();
//		first.setColor("#000000");
//		first.setValue(title);
//		m.put("first", first);
		
		
		
		
		
		
		
		
		com.alibaba.fastjson.JSONObject keyword1  = new com.alibaba.fastjson.JSONObject();
		keyword1.put("color", "#000000");
		keyword1.put("value", receiverImfo);
		com.alibaba.fastjson.JSONObject keyword2  = new com.alibaba.fastjson.JSONObject();
		keyword1.put("color", "#000000");
		keyword1.put("value", receiverPlace);
		com.alibaba.fastjson.JSONObject keyword3  = new com.alibaba.fastjson.JSONObject();
		keyword1.put("color", "#000000");
		keyword1.put("value", receiverPlace);
		com.alibaba.fastjson.JSONObject keyword4  = new com.alibaba.fastjson.JSONObject();
		keyword1.put("color", "#000000");
		keyword1.put("value", orderDetail);
		com.alibaba.fastjson.JSONObject keyword5  = new com.alibaba.fastjson.JSONObject();
		keyword1.put("color", "#000000");
		keyword1.put("value", orderRemark);
		
//		
//		Map<String, Object> data = new HashMap<String, Object>();
//		data.put(key, value)
		
		
//		// 订单号
//		TemplateData keyword1 = new TemplateData();
//		keyword1.setColor("#000000");
//		keyword1.setValue(receiverImfo);
//		m.put("keyword1", keyword1);
//
//		// 订单商品
//		TemplateData keyword2 = new TemplateData();
//		keyword2.setColor("#000000");
//		keyword2.setValue(receiverPlace);
//		m.put("keyword2", keyword2);
//		
//		// 商品数量
//		TemplateData keyword3 = new TemplateData();
//		keyword3.setColor("#000000");
//		keyword3.setValue(receiverPlace);
//		m.put("keyword3", keyword3);
//
//		// 订单总价
//		TemplateData keyword4 = new TemplateData();
//		keyword4.setColor("#000000");
//		keyword4.setValue(orderDetail);
//		m.put("keyword4", keyword4);
//		
//		// 备注
//		TemplateData remark = new TemplateData();
//		remark.setColor("#000000");
//		remark.setValue(orderRemark);
//		m.put("remark", remark);
		
		//模板内容
		return JSONObject.fromObject(m);
	}
	
	//-----------------------------
	//以下为获取微信消息模板参数内容
	
	/**"sendOrderDelivery"
	 * 订单发货通知
	 */
	public static JSONObject getSendOrderDeliveryData(String title, String orderId, String deliveryName, String deliveryId, String content)
	{
		Map<String, TemplateData> m = new HashMap<String, TemplateData>();
		// 标题
		TemplateData first = new TemplateData();
		first.setColor("#000000");
		first.setValue(title);
		m.put("first", first);
		// 订单号
		TemplateData keyword1 = new TemplateData();
		keyword1.setColor("#000000");
		keyword1.setValue(orderId);
		m.put("keyword1", keyword1);
		// 快递公司
		TemplateData keyword2 = new TemplateData();
		keyword2.setColor("#000000");
		keyword2.setValue(deliveryName);
		m.put("keyword2", keyword2);
		// 快递单号
		TemplateData keyword3 = new TemplateData();
		keyword3.setColor("#000000");
		keyword3.setValue(deliveryId);
		m.put("keyword3", keyword3);
		// 备注
		TemplateData remark = new TemplateData();
		remark.setColor("#000000");
		remark.setValue(content);
		m.put("remark", remark);
		//模板内容
		return JSONObject.fromObject(m);
	}
	
	/**
	 * 退货申请结果通知，编号：TM00587
	 */
///*
  	/**
  	  * @Title: getSendRefundApplyData
  	  * @Description: 模板消息-获取售后详情信息Data
  	  * @param @param title // 标题
  	  * @param @param orderId //订单号
  	  * @param @param tradeno //微信交易号
  	  * @param @param refundno //申请退货号
  	  * @param @param refundproduct //退货商品
  	  * @param @param refundnum //退货数量
  	  * @param @param refundmoney //退货金额
  	  * @param @param content //备注
  	  * @param @return    设定文件
  	  * @return JSONObject    返回类型 JSONObject
  	  * @throws
  	  */
  	public static JSONObject getSendRefundApplyData(String title, String orderId, String tradeno, String refundno, String refundproduct, String refundnum, String refundmoney, String content)
  	{
		Map<String, TemplateData> m = new HashMap<String, TemplateData>();
		// 标题
		TemplateData first = new TemplateData();
		first.setColor("#000000");
		first.setValue(title);
		m.put("first", first);
		//订单号
		TemplateData keyword1 = new TemplateData();
		keyword1.setColor("#000000");
		keyword1.setValue(orderId);
		m.put("orderno", keyword1);
		//微信交易号
		TemplateData keyword2 = new TemplateData();
		keyword2.setColor("#000000");
		keyword2.setValue(tradeno);
		m.put("tradeno", keyword2);
		//申请退货号
		TemplateData keyword3 = new TemplateData();
		keyword3.setColor("#000000");
		keyword3.setValue(refundno);
		m.put("refundno", keyword3);
		//退货商品
		TemplateData keyword4 = new TemplateData();
		keyword4.setColor("#000000");
		keyword4.setValue(refundproduct);
		m.put("refundproduct", keyword4);
		//退货数量
		TemplateData keyword5 = new TemplateData();
		keyword5.setColor("#000000");
		keyword5.setValue(refundnum);
		m.put("refundnum", keyword5);
		//退货金额
		TemplateData keyword6 = new TemplateData();
		keyword6.setColor("#000000");
		keyword6.setValue(refundmoney);
		m.put("refundmoney", keyword6);
		// 备注
		TemplateData remark = new TemplateData();
		remark.setColor("#000000");
		remark.setValue(content);
		m.put("remark", remark);

		//模板内容
		return JSONObject.fromObject(m);
	}
  	//*/
	
	/**
	 * 订单状态更新，编号：TM00017
	 * 
	 * @param request
	 * @return
	 */
///*	
  	/**
  	  * @Title: orderStatusUpdate
  	  * @Description: 模板消息-获取订单更新详情信息Data
  	  * @param @param title // 标题
  	  * @param @param orderId //订单号
  	  * @param @param orderStatus /订单状态
  	  * @param @param content    //备注
  	  * @return void    返回类型 JSONObject
  	  * @throws
  	  */
  	public static JSONObject getOrderStatusUpdateData(String title, String orderId, String orderStatus, String content) 
  	{
		Map<String, TemplateData> m = new HashMap<String, TemplateData>();
		// 标题
		TemplateData first = new TemplateData();
		first.setColor("#000000");
		first.setValue(title);
		m.put("first", first);
		// 订单号
		TemplateData keyword1 = new TemplateData();
		keyword1.setColor("#000000");
		keyword1.setValue(orderId);
		m.put("OrderSn", keyword1);
		// 订单状态
		TemplateData keyword2 = new TemplateData();
		keyword2.setColor("#000000");
		keyword2.setValue(orderStatus);
		m.put("OrderStatus", keyword2);
		// 备注
		TemplateData remark = new TemplateData();
		remark.setColor("#000000");
		remark.setValue(content);
		m.put("remark", remark);

		//模板内容
		return JSONObject.fromObject(m);
	}
	//*/
	
	/**
	 * 订单取消通知，编号：TM00850
	 */
/*	public void sendOrderCancel(HttpServletRequest request, HttpServletResponse response){
		PrintWriter out = null;
		response.setContentType("text/html");
		try {
			out = response.getWriter();
			String openId = (String) request.getSession().getAttribute("memberOpenId");//"oe62ns-nxA81yZLp3WwazS6pzYT0";
			String title = request.getParameter("title"); // 标题
			String orderProductPrice = request.getParameter("orderProductPrice"); //订单金额
			String orderProductName = request.getParameter("orderProductName");//商品详情
			String orderAddress = request.getParameter("orderAddress"); //收货信息
			String orderName = request.getParameter("orderName");//订单编号
			String content = request.getParameter("remark"); //备注
			String url = request.getParameter("url"); //详情的URL
			// 1、获取access_token
			String access_token = getAccessToken();
			// 2、获取模板ID
//			String template_id = getTemplateId(access_token, "TM00850");
			String template_id = propUtil.getProperty("sendOrderCancel").trim();
			WxTemplate t = new WxTemplate();
			t.setUrl(url);
			t.setTouser(openId);
			t.setTopcolor("#000000");
			// 模板ID
			t.setTemplate_id(template_id);
			Map<String, TemplateData> m = new HashMap<String, TemplateData>();
			// 标题
			TemplateData first = new TemplateData();
			first.setColor("#000000");
			first.setValue(title);
			m.put("first", first);
			// 订单金额
			TemplateData keyword1 = new TemplateData();
			keyword1.setColor("#000000");
			keyword1.setValue(orderProductPrice);
			m.put("orderProductPrice", keyword1);
			//商品详情
			TemplateData keyword2 = new TemplateData();
			keyword2.setColor("#000000");
			keyword2.setValue(orderProductName);
			m.put("orderProductName", keyword2);
			//收货信息
			TemplateData keyword3 = new TemplateData();
			keyword3.setColor("#000000");
			keyword3.setValue(orderAddress);
			m.put("orderAddress", keyword3);
			//订单编号
			TemplateData keyword4 = new TemplateData();
			keyword4.setColor("#000000");
			keyword4.setValue(orderName);
			m.put("orderName", keyword4);
			// 备注
			TemplateData remark = new TemplateData();
			remark.setColor("#000000");
			remark.setValue(content);
			m.put("remark", remark);
			t.setData(m);
			//发送模板消息
			JSONObject jsonobj = sendMsgTemplate(access_token, t);
			out.print(jsonobj.toString());
		} catch (Exception e) {
			e.printStackTrace();
			out.print(e);
		} finally {
			out.flush();
		}
	}*/
	
	
	//-----------------------------

    /** 
     * 发送POST请求 
     *  
     * @param url 
     *            目的地址 
     * @param parameters 
     *            请求参数，Map类型。 
     * @return 远程响应结果 
     */  
    public static String sendPost(String url, Map<String, String> parameters) {  
        String result = "";// 返回的结果  
        BufferedReader in = null;// 读取响应输入流  
        PrintWriter out = null;  
        StringBuffer sb = new StringBuffer();// 处理请求参数  
        String params = "";// 编码之后的参数  
        try {  
            // 编码请求参数  
            if (parameters.size() == 1) {  
                for (String name : parameters.keySet()) {  
                    sb.append(name).append("=").append(  
                            java.net.URLEncoder.encode(parameters.get(name),  
                                    "UTF-8"));  
                }  
                params = sb.toString();  
            } else {  
                for (String name : parameters.keySet()) {  
                    sb.append(name).append("=").append(  
                            java.net.URLEncoder.encode(parameters.get(name),  
                                    "UTF-8")).append("&");  
                }  
                String temp_params = sb.toString();  
                params = temp_params.substring(0, temp_params.length() - 1);  
            }  
            // 创建URL对象  
            java.net.URL connURL = new java.net.URL(url);  
            // 打开URL连接  
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL  
                    .openConnection();  
            // 设置通用属性  
            httpConn.setRequestProperty("Accept", "*/*");  
            httpConn.setRequestProperty("Connection", "Keep-Alive");  
            httpConn.setRequestProperty("User-Agent",  
                    "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");  
            // 设置POST方式  
            httpConn.setDoInput(true);  
            httpConn.setDoOutput(true);  
            // 获取HttpURLConnection对象对应的输出流  
            out = new PrintWriter(httpConn.getOutputStream());  
            System.out.println(params);
            // 发送请求参数  
            out.write(params);  
            // flush输出流的缓冲  
            out.flush();  
            // 定义BufferedReader输入流来读取URL的响应，设置编码方式  
            in = new BufferedReader(new InputStreamReader(httpConn  
                    .getInputStream(), "UTF-8"));  
            String line;  
            // 读取返回的内容  
            while ((line = in.readLine()) != null) {  
                result += line;  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (out != null) {  
                    out.close();  
                }  
                if (in != null) {  
                    in.close();  
                }  
            } catch (IOException ex) {  
                ex.printStackTrace();  
            }  
        }  
        return result;  
    } 	
}
