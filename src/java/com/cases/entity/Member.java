package com.cases.entity;

import java.util.Date;
import java.util.UUID;

import com.alibaba.fastjson.annotation.JSONType;
import com.cases.enums.Gender;

@JSONType(orders = { "id", "company", "username", "gender", "mobile", "createDate", "updateDate" })
public class Member {
	private String id = UUID.randomUUID().toString(); // ID
	private Company company; // 所属公司
	private String username; // 会员名
	private Gender gender; // 性别
	private String mobile; // 手机
	private Date createDate = new Date(); // 创建日期
	private Date updateDate; // 最后更新日期

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
