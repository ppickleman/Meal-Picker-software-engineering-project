package com.hongxun.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hongxun.entity.FoodDao;
import com.hongxun.entity.OrderDao;
import com.hongxun.entity.OrderItemDao;
import com.hongxun.entity.RestaurantDao;
import com.hongxun.repository.RestaurantRepository;
import com.hongxun.repository.OrderRepository;
import com.hongxun.service.MealService;

@Service
public class MealServiceImpl implements MealService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	public List<OrderDao> search(String foodType, String zip, double minPrice, double maxPrice) {
		ArrayList<OrderDao> result = new ArrayList<OrderDao>();
		// search all the restaurants from that zip code
		List<RestaurantDao> restaurants = restaurantRepository.queryRestaurantByTypeAndZip(foodType, zip);
		// start compute the price
		for (int i = 0; i < restaurants.size(); i++) {
			Object[] objs = restaurants.get(i).getFoodSet().toArray();
			int length = 0;
			// calculate length
			for (int power = 0; power < objs.length; power++)
				length += 1 << power;
			OrderDao[] meals = new OrderDao[length];
			combineFood(objs, 0, meals, 0, length);
			// filter result
			for (int j = 0; j < meals.length; j++) {
				double price = 0;
				for (OrderItemDao item : meals[j].getOrderItemSet())
					price += item.getPrice();
				if (minPrice <= price && price <= maxPrice) {
					meals[j].setRestaurant(restaurants.get(i));
					result.add(meals[j]);
				}
			}
		}
		return result;
	}

	private void combineFood(Object[] objs, int index, OrderDao[] result, int begin, int end) {
		int middle = (begin + end) / 2;
		if (index >= objs.length)
			return;
		for (int i = begin; i <= middle; i++) {
			if (i >= result.length)
				return;
			if (result[i] == null) {
				result[i] = new OrderDao();
				Set<OrderItemDao> items = new HashSet<OrderItemDao>();
				FoodDao food = (FoodDao) objs[index];
				items.add(new OrderItemDao(food, 1, food.getPrice()));
				result[i].setOrderItemSet(items);
			} else {
				FoodDao food = (FoodDao) objs[index];
				result[i].getOrderItemSet().add(new OrderItemDao(food, 1, food.getPrice()));
			}
		}
		combineFood(objs, ++index, result, begin, middle);
		combineFood(objs, index, result, middle + 1, end);
	}
}