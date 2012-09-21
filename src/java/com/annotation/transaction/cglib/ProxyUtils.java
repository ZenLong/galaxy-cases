package com.annotation.transaction.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import com.annotation.transaction.Tx;

public class ProxyUtils implements MethodInterceptor {
	private Object src;

	private ProxyUtils(Object src) {
		this.src = src;
	}

	@SuppressWarnings("unchecked")
	public static <T> T newProxy(T t) {
		Enhancer en = new Enhancer();
		en.setSuperclass(t.getClass());
		en.setCallback(new ProxyUtils(t));
		Object o = en.create();
		return (T) o;
	}

	// 方法拦截器
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		Object o = null;

		if (method.isAnnotationPresent(Tx.class)) {
			try {
				System.out.println("[ProxyUtils] Begin transaction");
				o = method.invoke(src, args);
				System.out.println("[ProxyUtils] Commit transaction");
			} catch (Exception e) {
				System.err.println("[ProxyUtils] Rollback transaction");
			} finally {
				System.out.println("[ProxyUtils] Release connection");
			}
		} else {
			o = method.invoke(src, args);
		}
		return o;
	}

}
