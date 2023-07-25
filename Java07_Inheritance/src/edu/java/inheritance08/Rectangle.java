package edu.java.inheritance08;

public class Rectangle extends Shape {
	private double width; // 직사각형의 가로 길이
	private double heigth; // 직사각형의 세로 길이
	
	// 생성자를 수정하여 필드의 가로, 세로를 초기화 할수 있도록
	public Rectangle(String type, double width, double heigth) {
		super(type); // 상위 클래스의 argument를 갖는 생성자를 명시적으로 호출.
		this.width = width;
		this.heigth = heigth;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double area() {
		return this.width * this.heigth;
	}

	@Override
	public double perimeter() {
		return this.width*2 + this.heigth*2;
	}

}
