package com.annotation.transaction;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 事务注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value=ElementType.METHOD)
public @interface Tx {}
