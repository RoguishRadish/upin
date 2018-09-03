package com.upin.entity.banner;

import org.apache.ibatis.type.Alias;

/**
 * 轮播图
 * @author Administrator
 *
 */
@Alias("Banner")
public class Banner {
	/**
	 * 编号=goods.id
	 */
	private String id;
	/**
	 * 轮播顺序
	 */
	private String value;
	/**
	 * 是否使用(1是0否)
	 */
	private String ison;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getIson() {
		return ison;
	}
	public void setIson(String ison) {
		this.ison = ison;
	}
}
