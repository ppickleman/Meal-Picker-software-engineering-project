package com.hongxun.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class AccountDao {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "username")
	private String userName;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@OneToMany(targetEntity = OrderDao.class, mappedBy = "account", fetch = FetchType.EAGER)
	private Set<OrderDao> orders;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<OrderDao> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderDao> orders) {
		this.orders = orders;
	}

	public AccountDao() {
		super();
	}

	public AccountDao(Long id) {
		super();
		this.id = id;
	}

	public AccountDao(String userName, String email, String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
	}
}
