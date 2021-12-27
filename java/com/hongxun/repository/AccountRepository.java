package com.hongxun.repository;

import java.io.Serializable;
import java.util.List;

import com.hongxun.entity.AccountDao;
import com.hongxun.entity.OrderDao;

public interface AccountRepository<T, PK extends Serializable> {
	public void register(String username, String email, String password) throws Exception;

	public AccountDao findAccount(String username, String email, String password) throws Exception;

	public List<OrderDao> getOrderHistory(AccountDao account) throws Exception;
}
