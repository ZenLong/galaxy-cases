package com.annotation.test;

@Description(author = "helloworld", size = 200)
public class DescriptionTest {

	public static void main(String[] args) {
		Class<DescriptionTest> clazz = DescriptionTest.class;
		if (clazz.isAnnotationPresent(Description.class)) {
			Description desc = (Description) clazz.getAnnotation(Description.class);
			System.out.println("desc.author:" + desc.author());
			System.out.println("desc.size:" + desc.size());
		} else {
			System.out.println("没有在DescriptionTest上使用注解!");
		}
	}

}
