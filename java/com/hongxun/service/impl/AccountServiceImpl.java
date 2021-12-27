package com.hongxun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hongxun.entity.AccountDao;
import com.hongxun.entity.CommonMsg;
import com.hongxun.entity.OrderDao;
import com.hongxun.enums.CommonStatus;
import com.hongxun.repository.AccountRepository;
import com.hongxun.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	public CommonMsg register(String username, String email, String password) {
		try {
			accountRepository.register(username, email, password);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMsg(CommonStatus.FAILED, "Something wrong!");
		}
		return new CommonMsg(CommonStatus.SUCCESSED, "");
	}

	public String modifyPwd() {
		// TODO Auto-generated method stub
		return null;
	}

	public AccountDao findAccount(String username, String email, String password) {
		try {
			return accountRepository.findAccount(username, email, password);
		} catch (Exception e) {
			return null;
		}
	}

	public List<OrderDao> viewOrderHistory(AccountDao account) {
		try {
			return accountRepository.getOrderHistory(account);
		} catch (Exception e) {
			return null;
		}
	}
}
