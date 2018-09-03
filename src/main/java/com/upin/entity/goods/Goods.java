package com.upin.entity.goods;

import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 商品表-实体类
 * @author Administrator
 *
 */
@Alias("Goods")
public class Goods {
	/**
	 * 编号
	 */
	private String id;
	/**
	 * 商品名称
	 */
	private String name;
	/**
	 * 展示图品路径id
	 */
	private String picId;
	/**
	 * 所有图片路径ids
	 */
	private String picIds;
	/**
	 * 视频路径url
	 */
	private String videoUrl;
	/**
	 * 详情
	 */
	private String detail;
	/**
	 * 状态(1下架,2上架,3完成)
	 */
	private String status;
	/**
	 * 单价
	 */
	private String price;
	
	/**
	 * 图片picIdsList
	 */
	private List<Object> picIdsList;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicId() {
		return picId;
	}

	public void setPicId(String picId) {
		this.picId = picId;
	}

	public String getPicIds() {
		return picIds;
	}

	public void setPicIds(String picIds) {
		this.picIds = picIds;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public List<Object> getPicIdsList() {
		return picIdsList;
	}

	public void setPicIdsList(List<Object> picIdsList) {
		this.picIdsList = picIdsList;
	}
}
