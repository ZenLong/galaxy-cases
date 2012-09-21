package com.annotation.transaction;

import com.annotation.transaction.cglib.ProxyUtils;

public class One implements IOne {

	@Tx
	public void save() {
		System.out.println("保存...");
	}

	public void del() {
		System.out.println("删除...");
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("---------测试cglib的方法拦截器，是此时是定义于接口上的注解在起作用---------");
		IOne one = TxProxy.newProxy(One.class);
		one.save();  //此方法将会处理事务
		one.del();
		Thread.sleep(3000);
		System.out.println("\n\n");
		System.out.println("---------测试cglib的方法拦截器，有所不同的是此时是定义于具体实现类上的注解在起作用---------");
		one = ProxyUtils.newProxy(new One());
		one.save();  //此方法将会处理事务
		one.del();
	}

}
