package com.common.utils;

/**
 * 微信推送模版实体类--缴费提醒
 * 
 * @author wenqiangxu
 *
 */
public class PayRemindDto {
	private String	title;		// 标题
	private String	content;    // 内容
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
}
