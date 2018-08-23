package com.upin.dao.goods;

import java.util.List;
import java.util.Map;

public interface GoodsDao {

	/**
	 * 根据id查询
	 */
	List<Map<String, String>> getOneById(Map<String, String> map);

	/**
	 * 查询商品所有图片
	 */
	List<Map<String, String>> getPicUrls(Map<String, Object> map);

	/**
	 * 查询
	 */
	List<Map<String, Object>> getGoodsList(Map<String, Object> map);

}
