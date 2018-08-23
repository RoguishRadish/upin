package com.common.utils;

import java.math.BigDecimal;
/**
 * 微信推送模版实体类
 * 
 * @author wenqiangxu
 *
 */
public class MessageModeDto extends PayRemindDto{
	private String		houseName;		// 房屋名称
	private String		itemName;		// 费用名称
	private BigDecimal	maxAmt;			// 应缴金额
	private BigDecimal	discountAmt;    // 优惠金额
	private BigDecimal	trueAmt;		// 实缴金额
	private BigDecimal	balAmt;			// 可用金额
	private String		lastNowArea;    // 缴费区间
	private String		time;		    // 缴费截止时间
	
	public String getHouseName() {
		return houseName;
	}
	
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public BigDecimal getMaxAmt() {
		return maxAmt;
	}
	
	public void setMaxAmt(BigDecimal maxAmt) {
		this.maxAmt = maxAmt;
	}
	
	public BigDecimal getDiscountAmt() {
		return discountAmt;
	}
	
	public void setDiscountAmt(BigDecimal discountAmt) {
		this.discountAmt = discountAmt;
	}
	
	public BigDecimal getTrueAmt() {
		return trueAmt;
	}
	
	public void setTrueAmt(BigDecimal trueAmt) {
		this.trueAmt = trueAmt;
	}
	
	public BigDecimal getBalAmt() {
		return balAmt;
	}
	
	public void setBalAmt(BigDecimal balAmt) {
		this.balAmt = balAmt;
	}
	
	public String getLastNowArea() {
		return lastNowArea;
	}
	
	public void setLastNowArea(String lastNowArea) {
		this.lastNowArea = lastNowArea;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
}
