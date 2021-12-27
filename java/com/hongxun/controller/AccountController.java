package com.hongxun.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hongxun.entity.AccountDao;
import com.hongxun.entity.CommonMsg;
import com.hongxun.entity.FoodDao;
import com.hongxun.entity.OrderDao;
import com.hongxun.entity.OrderItemDao;
import com.hongxun.entity.RestaurantDao;
import com.hongxun.enums.CommonStatus;
import com.hongxun.service.AccountService;
import com.hongxun.service.OrderService;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private OrderService orderService;

	// µÇÂ¼
	@RequestMapping(value = "/logIn", method = RequestMethod.POST)
	@ResponseBody
	public CommonMsg logIn(String username, String email, String password) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		AccountDao account = accountService.findAccount(username, email, password);
		if (account != null) {
			request.getSession().setAttribute("Account", account);
			return new CommonMsg(CommonStatus.SUCCESSED, "");
		} else {
			return new CommonMsg(CommonStatus.FAILED, "Could not found this account!");
		}
	}

	@RequestMapping(value = "/viewOrderHistory", method = RequestMethod.GET)
	public String viewOrderHistory() {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		AccountDao account = (AccountDao) request.getSession().getAttribute("Account");
		if (account != null) {
			//request.setAttribute("OrderList", accountService.viewOrderHistory(account.getId().toString()));
			request.setAttribute("OrderList", accountService.viewOrderHistory(account));
			return "viewOrderHistory";
		} else {
			return "redirect:index";
		}
	}

	@RequestMapping(value = "/orderMeal", method = RequestMethod.POST)
	@ResponseBody
	public CommonMsg orderMeal(String rId, @RequestParam(value = "foods[]") String[] foods, @RequestParam(value = "prices[]") String[] prices) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		AccountDao account = (AccountDao) request.getSession().getAttribute("Account");
		if (account != null) {
			OrderDao order = new OrderDao();
			order.setRestaurant(new RestaurantDao(Long.parseLong(rId)));
			order.setAccount(new AccountDao(account.getId()));
			Set<OrderItemDao> orderItems = new HashSet<OrderItemDao>();
			for (int i = 0; i < prices.length; i++) {
				orderItems.add(new OrderItemDao(order, new FoodDao(Long.parseLong(foods[i])), 1, Double.parseDouble(prices[i])));
			}
			order.setOrderItemSet(orderItems);
			orderService.newOrder(order);
			return new CommonMsg(CommonStatus.SUCCESSED, "");
		} else {
			return new CommonMsg(CommonStatus.FAILED, "Please login first!");
		}
	}

	// @RequestMapping(value = "/logInTest", method = RequestMethod.GET)
	// public String logInTest() {
	// AccountDao account;
	// // Test case 1
	// account = accountService.findAccount("blablabla", "blablabla@gmail.com",
	// "blablabla");
	// System.out.println("Test 1: " + (account == null ? "Account not found" :
	// "Account found"));
	// // Test case 2
	// account = accountService.findAccount("lyc", "lyc@gmail.com", "123");
	// System.out.println("Test 2: " + (account == null ? "Account not found" :
	// "Account found"));
	// // Test case 3
	// account = accountService.findAccount("lyc", "lyc@gmail.com", "1234");
	// System.out.println("Test 3: " + (account == null ? "Account not found" :
	// "Account found"));
	// return "redirect:index";
	// }

	// ×¢²á
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	@ResponseBody
	public CommonMsg signUp(String username, String email, String password) {
		return accountService.register(username, email, password);
	}

	// µÇ³ö
	@RequestMapping(value = "/logOut", method = RequestMethod.GET)
	public String logOut(String username, String email, String password) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		request.getSession().removeAttribute("Account");
		return "redirect:index";
	}

	// ÐÞ¸ÄÃÜÂë
	@RequestMapping(value = "/modifyPwd", method = RequestMethod.POST)
	public String modifyPwd(String username, String email, String password) {
		return "redirect:index";
	}
}