package com.upin.service.goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {

	/**
	 * 根据id查询
	 * @param map
	 * @return
	 */
	List<Map<String, String>> getOneById(Map<String, String> map);

	/**
	 * 查询商品所有图片
	 * @param map
	 * @return
	 */
	List<Map<String, String>> getPicUrls(Map<String, Object> map);

	/**
	 * 查询
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getGoodsList(Map<String, Object> map);
}
