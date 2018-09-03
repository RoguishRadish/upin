package com.upin.entity.token;

import org.apache.ibatis.type.Alias;

/**
 * access_token
 * @author Administrator
 *
 */
@Alias("AccessToken")
public class AccessToken {
	//编号
	private String id;
	//TOKEN
	private String token;
	//上次推送日期
	private String lastTime;
	//更新时间
	private String updateTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getLastTime() {
		return lastTime;
	}
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
}
