package com.common.wxcategory;

/**
 * 微信通用常量类
 * @author Administrator
 *
 */
public class WxConst {
	/**
	 * 获取微信用户openId的URL
	 */
	static final public String openUrl = "https://api.weixin.qq.com/sns/jscode2session";
	/**
	 * 获取微信token的URL
	 */
	static final public String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token";
	/**
	 * 获取微信推送URL
	 */
	static final public String wxPushMessageUrl = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send";
	
	/**
	 * 超时时间
	 */
	static final public String timeOut = "60000";
}
