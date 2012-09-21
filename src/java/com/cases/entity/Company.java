package com.cases.entity;

import java.util.UUID;

import com.alibaba.fastjson.annotation.JSONType;

@JSONType(orders = { "id", "name" })
public class Company {
	private String id = UUID.randomUUID().toString();
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
