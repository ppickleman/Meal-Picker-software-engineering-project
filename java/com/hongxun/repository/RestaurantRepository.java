package com.hongxun.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.hongxun.entity.RestaurantDao;

public interface RestaurantRepository<T, PK extends Serializable> {
	public List<RestaurantDao> queryRestaurantByTypeAndZip(String foodType, String zip);
}
