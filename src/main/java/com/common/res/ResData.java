package com.common.res;

import com.alibaba.fastjson.JSONObject;
import com.common.constant.Const;

/**
 * ResData
 * @author Administrator
 *
 */
public class ResData extends JSONObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8455390348833122001L;

	/**
	 * 成功值1
	 */
	public void setSucceed() {
		this.put("code", Const.SUCCEED);
	}
	
	/**
	 * 成功值1
	 * 操作结果信息
	 */
	public void setSucceed(String msg) {
		this.put("code", Const.SUCCEED);
		this.put("resMsg", msg);
	}
	
	/**
	 * 成功值1
	 * 数据
	 */
	public void setSucceed(Object object) {
		this.put("code", Const.SUCCEED);
		this.put("resData", object);
	}
	
	/**
	 * 成功值1
	 * 操作结果信息
	 * 数据
	 */
	public void setSucceed(String msg, Object object) {
		this.put("code", Const.SUCCEED);
		this.put("resMsg", msg);
		this.put("resData", object);
	}
	
	/**
	 * 失败值0
	 */
	public void setFailed() {
		this.put("code", Const.FAIL);
	}
	
	/**
	 * 失败值0
	 * 操作信息
	 */
	public void setFailed(String msg) {
		this.put("code", Const.FAIL);
		this.put("resMsg", msg);
	}
	
	/**
	 * 失败值0
	 * 数据
	 */
	public void setFailed(Object object) {
		this.put("code", Const.FAIL);
		this.put("resData", object);
	}
	
	/**
	 * 失败值0
	 * 操作信息
	 * 数据
	 */
	public void setFailed(String msg, Object object) {
		this.put("code", Const.FAIL);
		this.put("resMsg", msg);
		this.put("resData", object);
	}
}
