package edu.java.exception06;

import java.util.Scanner;

public class ExceptionMain06 {

	private Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// inputInteger() 메서드 테스트 코드
		ExceptionMain06 app = new ExceptionMain06();
		int x = app.inputInteger();
		System.out.println("x= " + x);	
	}
	public int inputInteger() {
		// Scanner를 사용해서 입력받은 정수를 리턴.
		// Integer.parseInt(scnner.nextLine()) 과정에서 NumberFormatException 이 발생할 수 있음. 
		// 다시 입력하게끔 무한루프. while(true)
		int result = 0; // 변수 선언 목적은 루프안에서 사용하려고~!/ 콘솔에서 입력받은 값을 저장할 변수를 미리 선언해둠~!
		while (true) {
			try {
				System.out.print("정수를 입력> ");
				result = Integer.parseInt(scanner.nextLine());
				break; // 반복문을 끝냄.
			} catch (NumberFormatException e) {
				System.out.print("정수로 다시 입력>>>  ");
			}
		}
	
		return result;
	}
}
