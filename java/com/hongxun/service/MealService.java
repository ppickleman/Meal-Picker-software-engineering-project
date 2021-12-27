package com.hongxun.service;

import java.util.List;
import java.util.Set;

import com.hongxun.entity.OrderDao;

public interface MealService {
	public List<OrderDao> search(String foodType, String location, double minPrice, double maxPrice);
}
