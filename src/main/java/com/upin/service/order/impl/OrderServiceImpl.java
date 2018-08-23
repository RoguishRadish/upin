package com.upin.service.order.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upin.dao.order.OrderDao;
import com.upin.entity.order.Order;
import com.upin.service.order.OrderService;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDao orderDao;
	
	@Override
	public List<Map<String, Object>> getOrderList(Map<String, Object> map) {
		List<Map<String, Object>> list = orderDao.getOrderList(map);
		return list;
	}

	@Override
	public List<Map<String, Object>> getOrderDetail(Map<String, Object> map) {
		List<Map<String, Object>> list = orderDao.getOrderDetail(map);
		return list;
	}

	@Override
	public void update(Order order) {
		orderDao.update(order);
	}

	@Override
	public void insert(Order order) {
		orderDao.insert(order);
	}

	@Override
	public Order getOneById(String orderId) {
		Order order = orderDao.getOneById(orderId);
		return order;
	}

}
