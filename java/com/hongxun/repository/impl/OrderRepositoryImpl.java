package com.hongxun.repository.impl;

import java.util.Date;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hongxun.entity.OrderDao;
import com.hongxun.entity.OrderItemDao;
import com.hongxun.repository.OrderRepository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.openSession();
	}

	public void saveOrder(OrderDao order) throws Exception {
		try {
			Session session = getCurrentSession();
			session.beginTransaction();
			order.setOrderTime(new Date());
			session.save(order);
			session.getTransaction().commit();
			session.close();
			// for (OrderItemDao item : order.getOrderItemSet())
			// getCurrentSession().save(item);
		} catch (Exception e) {
			throw e;
		}
	}

	public Set<OrderDao> viewOrderHistory() {
		// TODO Auto-generated method stub
		return null;
	}

}
