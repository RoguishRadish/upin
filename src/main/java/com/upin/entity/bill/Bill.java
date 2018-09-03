package com.upin.entity.bill;

import org.apache.ibatis.type.Alias;

/**
 * 账单表
 * @author Administrator
 *
 */
@Alias("Bill")
public class Bill {
	//账单编号
	private String id;
	//用户编号
	private String userId;
	//账单类型(fk付款,tx提现,tk退款)
	private String type;
	//金额
	private String money;
	//发生对象
	private String toUserId;
	//付款状态(0：未付款，1：已付款)
	private String state;
	//订单编号
	private String orderId;
	//创建时间
	private String createTime;
	//更新时间
	private String updateTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getToUserId() {
		return toUserId;
	}
	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
}
