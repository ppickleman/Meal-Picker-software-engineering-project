package com.hongxun.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hongxun.entity.AccountDao;
import com.hongxun.entity.OrderDao;
import com.hongxun.repository.AccountRepository;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.openSession();
	}

	public void register(String username, String email, String password) throws Exception {
		try {
			getCurrentSession().save(new AccountDao(username, email, password));
		} catch (Exception e) {
			throw e;
		}
	}

	public AccountDao findAccount(String username, String email, String password) throws Exception {
		AccountDao result = null;
		try {
			Query q = getCurrentSession().createQuery("from AccountDao where (username = ? or email = ?) and password = ?");
			q.setString(0, username);
			q.setString(1, email);
			q.setString(2, password);
			List list = q.list();
			result = (AccountDao) list.get(0);
		} catch (Exception e) {
			throw e;
		}
		return result;
	}

	public List<OrderDao> getOrderHistory(AccountDao account) throws Exception {
		List<OrderDao> result = null;
		try {
			Query q = getCurrentSession().createQuery("from OrderDao where a_id = ? order by order_time desc");
			q.setLong(0, account.getId());
			result = q.list();
		} catch (Exception e) {
			throw e;
		}
		// List<OrderDao> result = new ArrayList<OrderDao>();
		// getCurrentSession().refresh(account);
		// for (OrderDao obj : account.getOrders())
		// result.add(obj);
		return result;
	}
}
