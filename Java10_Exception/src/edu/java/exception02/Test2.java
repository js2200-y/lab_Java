package edu.java.exception02;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		try {
			System.out.print("x 입력>>  ");
			int x = Integer.parseInt(sc.nextLine());
			
			System.out.print("y 입력>>  ");
			int y = Integer.parseInt(sc.nextLine());
			
			int result = x / y;
			System.out.println(result);
			
		} catch (ArithmeticException e) {
			System.out.println("y는 0이 될 수 없음.");
		}
			
		
		
		
		
		
		
		
		
		
		
	}
}
