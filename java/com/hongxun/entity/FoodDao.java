package com.hongxun.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "food")
public class FoodDao {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private double price;

	@ManyToOne(targetEntity = RestaurantDao.class)
	@JoinColumn(name = "r_id")
	private RestaurantDao restaurant;

	@ManyToMany(targetEntity = TagDao.class)
	@JoinTable(name = "food_to_tag", joinColumns = { @JoinColumn(name = "f_id") }, inverseJoinColumns = { @JoinColumn(name = "t_id") })
	private Set<TagDao> tags;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public RestaurantDao getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantDao restaurant) {
		this.restaurant = restaurant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<TagDao> getTags() {
		return tags;
	}

	public void setTags(Set<TagDao> tags) {
		this.tags = tags;
	}

	public FoodDao() {
		super();
	}

	public FoodDao(Long id) {
		super();
		this.id = id;
	}

	public FoodDao(Long id, String name, double price, RestaurantDao restaurant, Set<TagDao> tags) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.restaurant = restaurant;
		this.tags = tags;
	}
}
