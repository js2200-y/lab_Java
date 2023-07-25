package edu.java.class06;

public class ClassMain06 {

	public static void main(String[] args) {
		Circle circle1 = new Circle(); // 기본 생성자 호출
		circle1.printCircleInfo();
		System.out.println("원의 둘레: " + circle1.perimeter());
		System.out.println("원의 넓이: " + circle1.area());
		
		Circle circle2 = new Circle(5); // argument 1개를 갖는 생성자
		circle2.printCircleInfo();
		System.out.println("원의 둘레: " + circle2.perimeter());
		System.out.println("원의 넓이: " + circle2.area());
		
	}

}
