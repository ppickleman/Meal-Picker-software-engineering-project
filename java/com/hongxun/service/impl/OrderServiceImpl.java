package com.hongxun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hongxun.entity.OrderDao;
import com.hongxun.repository.OrderRepository;
import com.hongxun.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public void newOrder(OrderDao order) {
		try {
			orderRepository.saveOrder(order);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
