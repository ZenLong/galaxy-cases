package com.annotation.transaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 事务拦截模拟
 */
public class TxProxy implements InvocationHandler {
	private Object obj;

	private TxProxy(Object obj) {
		this.obj = obj;
	}

	// 接收一个被代理的对象
	public static Object newProxy(Object o) {
		Object proxy = Proxy.newProxyInstance(TxProxy.class.getClassLoader(), o.getClass().getInterfaces(),
				new TxProxy(o));
		return proxy;
	}

	// 使用泛型，接收被代理类的Class对象
	@SuppressWarnings("unchecked")
	public static <T> T newProxy(Class<T> cls) {
		Object o = null;
		try {
			o = cls.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Object proxy = Proxy.newProxyInstance(TxProxy.class.getClassLoader(), o.getClass().getInterfaces(),
				new TxProxy(o));
		return (T) proxy;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object res = null;
		if (method.isAnnotationPresent(Tx.class)) {// 判断是否添加了Tx事务注解
			try {
				System.out.println("[TxProxy] Begin transaction");
				res = method.invoke(obj, args);
				System.out.println("[TxProxy] Commit transaction");
			} catch (Exception e) {
				System.err.println("[TxProxy] Rollback transaction");
				throw new RuntimeException(e.getMessage(), e);
			} finally {
				System.out.println("[TxProxy] Release connection");
			}
		} else {
			res = method.invoke(obj, args);
		}
		return res;
	}

}
