package com.upin.entity.user;

/**
 * 微信用户表-实体类
 * @author Administrator
 *
 */
public class WXUser {
	/**
	 * 用户编号
	 */
	private String id;
	/**
	 * 用户昵称
	 */
	private String nickName;
	/**
	 * 头像url
	 */
	private String userPic;
	/**
	 * 微信openid
	 */
	private String openId;
	/**
	 * 真实姓名
	 */
	private String userName;
	/**
	 * 性别标识{1男 2女}
	 */
	private String sex;
	/**
	 * 身份证号
	 */
	private String identityNum;
	/**
	 * 手机号
	 */
	private String phone;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 金额
	 */
	private String money;
	/**
	 * 首次登陆时间
	 */
	private String firstLoginTime;
	/**
	 * 上次登录时间
	 */
	private String lastLoginTime;
	/**
	 * 登陆次数
	 */
	private String loginNum;
	
	private String createTime;
	private String updateTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserPic() {
		return userPic;
	}
	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIdentityNum() {
		return identityNum;
	}
	public void setIdentityNum(String identityNum) {
		this.identityNum = identityNum;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getFirstLoginTime() {
		return firstLoginTime;
	}
	public void setFirstLoginTime(String firstLoginTime) {
		this.firstLoginTime = firstLoginTime;
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getLoginNum() {
		return loginNum;
	}
	public void setLoginNum(String loginNum) {
		this.loginNum = loginNum;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
}
