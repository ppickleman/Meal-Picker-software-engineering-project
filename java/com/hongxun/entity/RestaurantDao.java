package com.hongxun.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "restaurant")
public class RestaurantDao {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "location")
	private String location;

	@Column(name = "type")
	private String type;

	@OneToMany(targetEntity = FoodDao.class, mappedBy = "restaurant")
	private Set<FoodDao> foodSet;

	@Column(name = "zip")
	private String zip;

	@Column(name = "img_src")
	private String imgSrc;

	@Column(name = "url")
	private String url;
	
	@Column(name = "order_url")
	private String orderUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<FoodDao> getFoodSet() {
		return foodSet;
	}

	public void setFoodSet(Set<FoodDao> foodSet) {
		this.foodSet = foodSet;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getOrderUrl() {
		return orderUrl;
	}

	public void setOrderUrl(String orderUrl) {
		this.orderUrl = orderUrl;
	}

	public RestaurantDao() {
		super();
	}

	public RestaurantDao(Long id) {
		super();
		this.id = id;
	}

	public RestaurantDao(Long id, String name, String location, String type, Set<FoodDao> foodSet, String zip, String imgSrc, String url) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.type = type;
		this.foodSet = foodSet;
		this.zip = zip;
		this.imgSrc = imgSrc;
		this.url = url;
	}
}
