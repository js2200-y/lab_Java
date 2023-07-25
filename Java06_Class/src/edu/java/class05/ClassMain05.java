package edu.java.class05;

public class ClassMain05 {

	public static void main(String[] args) {
		// 기본 생성자를 이용한 Rdctangle 객체 생성
		Rectangle rect1 = new Rectangle();
		System.out.println(rect1);
		System.out.println(rect1.width+ ","+ rect1.heigh);
		rect1.width = 1.0; // 생성된 rect1 직사각형 객체의 가로길이 변경
		rect1.heigh = 2.0;
		System.out.println(rect1.perimeter());
		System.out.println(rect1.area());
//	Rectangle rectangle1 = new Rectangle(5,4);
//	rectangle1.printRectangleperimeter();
//	
//		Rectangle rectangle2 = new Rectangle(5,4);
//		rectangle2.pirntRectanglearea();
//
		// argument를 갖는 생성자를 이용한 Rectangle 객체 생성.
		Rectangle rect2 = new Rectangle(4, 3);
		System.out.println(rect2);
		System.out.println(rect2.width + " , " + rect2.heigh);
		
		System.out.println("둘레: " + rect2.perimeter());
		System.out.println("넓이: " + rect2.area());

	}

}
