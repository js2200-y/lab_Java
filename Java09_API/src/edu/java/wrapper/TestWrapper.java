package edu.java.wrapper;

import java.math.BigDecimal;

public class TestWrapper {

	public static void main(String[] args) {
		int x = 1;
		
		Integer number1 = Integer.valueOf(1);
		System.out.println(number1);
		
		Integer number2 = Integer.valueOf("123");
		System.out.println(number2);
		
		
		
		//-------------------------------
		Integer number3 = 1;
		
		int y = number3.intValue();
		System.out.println(y);
		
		
		int z = number3;
		
		int add = number1 + number2;
		System.out.println(add);
		
		int num = Integer.parseInt("100");
		System.out.println(num);
		
		Double d1 = 1.1;
		Double d2 = 0.9;
		
		System.out.println(d1-d2);
		
		BigDecimal big1 = new BigDecimal("1.1");
		BigDecimal big2 = new BigDecimal("0.9");
		System.out.println(big1);
		System.out.println(big2);
		System.out.println(big1.subtract(big2));
		
		
		
	}

}
