package edu.java.class05;

// 직사각형 
public class Rectangle {
	// field - 객체 속성
	
	double width;  // 직사각형 가로길이
	double heigh; // 직사각형 세로길이
	
	// 생성자 - 필드 초기화
	// (1) 기본생성자
	// (2) 직사각형의 가로/세로 길이를 전달받은 값으로 초기화 하는 생성자
	public Rectangle() {
		
	}
	
	public Rectangle(double width, double heigh) {
		this.width= width;
		this.heigh =heigh;
		
	}
		
	// 메서드
	// (1) perimeter - 직사각형의 둘레 길이를 리턴. 둘레의길이를 위해서 파라미터가 있어야하나?
	// (2) area - 직사각형의 넓이를 리턴.
	public double perimeter() {
		return (this.width + this.heigh) * 2;
	}
	
	public double area() {
		return this.width * this.heigh;
	}
	
//	public void printRectangleperimeter () {
//		System.out.println("둘레: "+ (width + heigh)*2);
//	
//	}
//	
//	public void pirntRectanglearea() {
//		System.out.println("넓이: "+ (width * heigh));
//	}
//	
	
	
}