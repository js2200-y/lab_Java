package edu.java.modifier03;

public class Person {
	// field
	private String name;
	private int age;
		
	// constructor  생성자는 클래스 이름과 같아야함.
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
	// method
	// getter 메서드 get뒤에변수이름 붙이기~! 파라미터 선언하지 않음.
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	// setter 메서드 리턴타입이 없어void , 파라미터 필요함~!
	public void setAge(int age) {
		if (age >= 0) {
			this.age = age;
		} else {
			System.out.println("음수 나이는 허용되지 않음.");
		}
		
		}
	
	
}
