package com.hongxun.entity;

import javax.persistence.*;

@Entity
@Table(name = "tag")
public class TagDao {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "name")
	private String name;

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

	public TagDao() {
		super();
	}

	public TagDao(String name) {
		super();
		this.name = name;
	}
}
