package edu.java.lambda01;

import edu.java.lambda01.Calculator.Calculable;

public class LambdaMain01 {

	public static void main(String[] args) {
		// Calculator 타입의 객체 생성
		Calculator calc = new Calculator(1, 2); // calc 계산기
		// Calculable 인터페이스 구현 클래스 타입의 객체 생성
		Calculable adder = new CalcAdder(); // 덧셈도구
		// 생성된 객체를 calculate 메서드의 argument로 전달.
		double result = calc.calcaulate(adder);
		System.out.println("result = " + result);

		// 지역(내부) 클래스
		class Subtractor implements Calculable {
			@Override
			public double calcaulate(double x, double y) {
				return x - y;
			}

		}

		Calculable subtractor = new Subtractor(); // 지역 클래스 객체 생성.
		result = calc.calcaulate(subtractor); //
		System.out.println("result = " + result);

		// 익명 클래스 객체 생성
		Calculable multiplier = new Calculable() {
			@Override
			public double calcaulate(double x, double y) {
				return x * y;
			}
		};
		result = calc.calcaulate(multiplier);
		System.out.println("result = " + result);

		
		
		result = calc.calcaulate(new Calculable() {
			@Override
			public double calcaulate(double x, double y) {
				return x / y;
			}
		});
		System.out.println("result = " + result);
		
		// 람다 표현식(lambda expression)
		result = calc.calcaulate((x,y) -> x /  y);
		System.out.println("result = " + result);
		
		/*
		 * 람다 표현식 - 함수 표기법
		 * 클래스 정의와 객체 생성을 동시에 하는 익명 클래스를 간단히 작성하기 위한 문법.
		 * 함수형 인터페이스(FunctionalInterface)만 람다 표현식으로 작성할 수 있음.
		 * - 함수형 인터페이스: 추상 메서드를 오직 1개만 갖는 인터페이스.
		 * 람다 표현식 문법: 
		 * 		(파라미터 선언, ...) -> { 메서드 코드; }
		 * 람다 표현식의 파라미터 선언에서는 타입을 생략해도 됨.
		 * 람다 표현식의 body가 문장이 하나만 있는 경우에는 { }를 생략할 수 있음.
		 * 람다 표현식의 body가 리턴문장 있는 경우에는 { }와 return 키워드를 모두 생략하고 리턴 값만 표기해도됨.
		 * 		(파라미터 선언,...) -> 리턴 값
		 * 람다 표현식에서 파라미터가 1개인 경우에는 ()를 생략할 수 있음.
		 * 		파라미터 -> {}
		 * 		파라미터 -> 리턴 값
		 */
		
	}

}
