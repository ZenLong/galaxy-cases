package com.cases;

import org.junit.Test;

public class TempCase {

	@Test
	public void test() {
	}
	
	/**
	 * 异或运算不借助中间变量就能交换两个整型变量值
	 */
	@Test
	public void TestXOR() {
		int a = 3, b = 4;
		a=a^b;
		b=a^b; 
		a=a^b;
		System.out.println(a + "," + b);
	}

}
