package edu.java.inheritance03;

public class Car {
//필드
	private double fuel;
	private double speed;
	
	//생성자
	public Car(double fuel, double speed) {
		this.fuel = fuel;
		this.speed = speed;
	}
	
	public double getFuel() {
		return this.fuel;
	}
	public double getSpeed() {
		return this.speed;
	}
	public void drive() {
		System.out.printf("자동차 운전: 속력 = %f, 연료 = %f\n",this.speed , this.fuel);
	}
}
