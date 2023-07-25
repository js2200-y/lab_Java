package edu.java.singleton;
// singleton(싱글톤) : 오직 한 번만 생성할 수 있는 객체.
// singleton = (1) private static 클래스 필드
//			   (2) private 생성자 
//			   (3) public static 클래스 메서드

public class Captain {
	private String name = "캡틴 아메리카";
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// (1) private static Captain 타입의 필드
	// 생성된 captain 타입 객체의 주소값을 저장하기 위한 필드.
	// static으로 선언한 이유는 
	//->프로그램 로딩 시점에 메서드 영역의 메모리에 미리 변수를 만들어 두기 위함.
	// private - 필드의 값을 변경하는 것은 클래스 내부에서만 가능하도록 하기 위함.
	private static Captain instance = null;
	
	// (2) private 생성자
	// 다른 클래스에서 생성자를 호출할 수 없도록 private를 붙임.
	// 다른 클래스에서 객체를 생성하지 못하도록~!
	private Captain() {}
		
	// (3) public static이고, Captain을 리턴하는 메서드
	// public- 다른클래스에서 사용할 수 있도록.
	// static- 캡틴 타입 객체가 생성되기 전에도 호출하기 위함.
		public static Captain getInstance() {
			if (instance == null) { // 캡틴 타입으로 생성된 객체가 없으면,
				instance = new Captain(); // 캡틴 타입 객체를 생성하고 인스턴스에 저장한다.(생성된 객체의 주소값)
			}
			return instance; // 캡틴 타입 객체의 주소값을 리턴.
		}
	}


