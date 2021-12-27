package com.hongxun.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hongxun.service.MealService;

@Controller
public class MealController {
	@Autowired
	private MealService mealService;

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String order() {
		return "index";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(String foodType, String zip, String minPrice, String maxPrice) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		request.setAttribute("MealList", mealService.search(foodType, zip, minPrice == null || minPrice == "" ? 0 : Double.parseDouble(minPrice), maxPrice == null || maxPrice == "" ? 9999 : Double.parseDouble(maxPrice)));
		return "foodList";
	}
}