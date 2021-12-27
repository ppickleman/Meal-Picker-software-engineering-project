package com.hongxun.repository.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hongxun.entity.RestaurantDao;
import com.hongxun.repository.RestaurantRepository;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.openSession();
	}

	public List<RestaurantDao> queryRestaurantByTypeAndZip(String foodType, String zip) {
		Query q = getCurrentSession().createQuery("from RestaurantDao where zip = ?" + ("All".equals(foodType) ? "" : " and type = ?"));
		q.setString(0, zip);
		if (!"All".equals(foodType))
			q.setString(1, foodType);
		List<RestaurantDao> list = q.list();
		return list;
	}
}
