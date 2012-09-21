package com.cases.enums;

public enum Gender {
	UNSPEC("未指定"), // 未指定
	MALE("男"), // 男
	FEMALE("女"); // 女

	private String label;

	private Gender(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
