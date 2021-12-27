package com.hongxun.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItemDao {
	@Id
	@GeneratedValue
	private long id;

	@ManyToOne(targetEntity = OrderDao.class)
	@JoinColumn(name = "o_id")
	private OrderDao order;

	@ManyToOne(targetEntity = FoodDao.class)
	@JoinColumn(name = "f_id")
	private FoodDao food;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "price")
	private double price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public OrderDao getOrder() {
		return order;
	}

	public void setOrder(OrderDao order) {
		this.order = order;
	}

	public FoodDao getFood() {
		return food;
	}

	public void setFood(FoodDao food) {
		this.food = food;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public OrderItemDao() {
		super();
	}

	public OrderItemDao(FoodDao food, int quantity, double price) {
		super();
		this.food = food;
		this.quantity = quantity;
		this.price = price;
	}

	public OrderItemDao(OrderDao order, FoodDao food, int quantity, double price) {
		super();
		this.order = order;
		this.food = food;
		this.quantity = quantity;
		this.price = price;
	}
}
