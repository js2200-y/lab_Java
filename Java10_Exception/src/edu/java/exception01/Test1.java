package edu.java.exception01;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력>> ");
		int x = Integer.parseInt(sc.nextLine());
		
		System.out.print("정수 입력>> ");
		int y = Integer.parseInt(sc.nextLine());
		
		if (y != 0) {
			System.out.println(x/y);
		} else {
			System.out.println("0으로 나눌 수 없음");
		}
		
	}
	private void printLength(String s) {
		if (s != null) {
			System.out.println(s.length());
		} else {
			System.out.println("null은 length를 알 수 없음.");
		}
		
		
		
		
		
		
		
		
	}

}
