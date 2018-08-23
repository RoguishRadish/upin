package com.upin.service.order;

import java.util.List;
import java.util.Map;

import com.upin.entity.order.Order;

public interface OrderService {

	/**
	 * 分页查询订单
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getOrderList(Map<String, Object> map);

	/**
	 * 根据orderId查询订单详情
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getOrderDetail(Map<String, Object> map);

	void update(Order order);

	void insert(Order order);

	Order getOneById(String orderId);

}
