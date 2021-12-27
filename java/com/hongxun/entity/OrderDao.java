package com.hongxun.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "mp_order")
public class OrderDao {
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(targetEntity = AccountDao.class)
	@JoinColumn(name = "a_id")
	private AccountDao account;

	@OneToMany(targetEntity = OrderItemDao.class, mappedBy = "order", cascade = CascadeType.ALL)
	private Set<OrderItemDao> orderItemSet;

	@Column(name = "order_time")
	private Date orderTime;

	@ManyToOne(targetEntity = RestaurantDao.class)
	@JoinColumn(name = "r_id")
	private RestaurantDao restaurant;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AccountDao getAccount() {
		return account;
	}

	public void setAccount(AccountDao account) {
		this.account = account;
	}

	public Set<OrderItemDao> getOrderItemSet() {
		return orderItemSet;
	}

	public void setOrderItemSet(Set<OrderItemDao> orderItemSet) {
		this.orderItemSet = orderItemSet;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public RestaurantDao getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantDao restaurant) {
		this.restaurant = restaurant;
	}

	public OrderDao() {
		super();
	}

	public OrderDao(Long id, AccountDao account, Set<OrderItemDao> orderItemSet, Date orderTime, RestaurantDao restaurant) {
		super();
		this.id = id;
		this.account = account;
		this.orderItemSet = orderItemSet;
		this.orderTime = orderTime;
		this.restaurant = restaurant;
	}
}
