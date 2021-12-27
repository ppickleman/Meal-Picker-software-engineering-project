package com.hongxun.repository;

import java.io.Serializable;
import java.util.Set;

import com.hongxun.entity.OrderDao;

public interface OrderRepository<T, PK extends Serializable> {
	void saveOrder(OrderDao order) throws Exception;

	public Set<OrderDao> viewOrderHistory();
}
