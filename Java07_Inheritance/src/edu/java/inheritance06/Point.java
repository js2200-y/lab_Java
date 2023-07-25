package edu.java.inheritance06;

import java.util.Objects;

public class Point {
	// 필드
	private int x;
	private int y;
	
	// toString override: "Point(x=0 , y=0)"
	@Override
	public String toString() {
//		return "Point [x=" + this.x + ", y=" + this.y + "]";
		String s = String.format("Point(x=%d, y=%d)", this.x, this.y);
		return s;
	}
	
	// 생성자 ( 기본생성자, argument 2개인 생성자)	
	public Point() {}
		
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// getters & setters
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	@Override
	// hashCode() 메서드는 반드시 int 타입을 리턴.
	// equals()가 true를 리턴하는 두 객체는 hashCode()의 리턴값이 같아야함.
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass()) // 클래스 이름이 다르면
//			return false;
//		// 클래스 이름이 같으면 -> casting 할수 있음.
//		Point other = (Point) obj;
//		return x == other.x && y == other.y;
//	}
//		
	public boolean equals(Object obj) {
		boolean result = false;
		
		if (obj instanceof Point) { // obj가 Point 타입의 인스턴스이면
			Point other = (Point) obj; // 안전한 타입변환(캐스팅)
			result = (this.x == other.x) && (this.y == other.y);
		} 
		
		return result;
		}
	
}


