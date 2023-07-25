package edu.java.inheritance08;

public class Circle extends Shape{
	// field
	private double radius; // 원의 반지름
	
	// 생성자
	public Circle(String type, double radius) {
		super(type);
		this.radius = radius;
	}

	@Override
	public double area() {
		return Math.PI * radius * radius;
	}

	@Override
	public double perimeter() {
		return this.radius * 2 * 3.14;
	}
	
	

	
	
	
	
}
