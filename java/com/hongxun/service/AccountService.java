package com.hongxun.service;

import java.util.List;

import com.hongxun.entity.AccountDao;
import com.hongxun.entity.CommonMsg;
import com.hongxun.entity.OrderDao;

public interface AccountService {
	public CommonMsg register(String username, String email, String password);

	public String modifyPwd();

	public AccountDao findAccount(String username, String email, String password);

	public List<OrderDao> viewOrderHistory(AccountDao account);
}
