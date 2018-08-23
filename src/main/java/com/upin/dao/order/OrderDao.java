package com.upin.dao.order;

import java.util.List;
import java.util.Map;

import com.upin.entity.order.Order;

public interface OrderDao {

	List<Map<String, Object>> getOrderList(Map<String, Object> map);

	List<Map<String, Object>> getOrderDetail(Map<String, Object> map);

	void update(Order order);

	void insert(Order order);

	Order getOneById(String orderId);


}
