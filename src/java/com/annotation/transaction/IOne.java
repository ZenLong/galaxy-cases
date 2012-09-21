package com.annotation.transaction;

public interface IOne {
	@Tx
	void save();// 添加需要处理事务的注解

	void del();
}
