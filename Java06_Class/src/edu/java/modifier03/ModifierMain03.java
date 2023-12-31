package edu.java.modifier03;

// 데이터 캡슐화(encapsulation):
// 객체의 필드(멤버 변수)들은 private으로 선언해서 클래스 외부에서 보이지 않도록 감추고,
// 대신에, 필요한 경우에 한해서 public으로 공개된 메서드를 제공함으로써
// 간접적으로 필드의 값을 읽거나 수정할 수 있도록 허용하는 프로그래밍 방법.
// getter 메서드 : 필드의 값을 리턴하는 메서드.
//					- 메서드의 이름은 보통 필드 이름 앞에 get을 붙여서 만듦.
//					- boolean 타입 필드의 getter 메서드는 get 또는 is를 붙여서 만듦.
// setter 메서드 : 필드의 값을 변경하는 메서드.
// 데이터 캡슐화를 사용하는 이유는 데이터의 보안과 무결성을 유지하기 위해서.

public class ModifierMain03 {

	public static void main(String[] args) {
		// Person 타입의 객체 생성.
		Person p1 = new Person("오쌤", 16);
//		p1.age = -16; // 필드 값 변경
//		System.out.println(p1.age); // 필드 값 읽기

		// private으로 감춰진 필드의 값 읽기 - > public으로 공개된 getter 메서드 사용
		System.out.println("이름: " + p1.getName());
		System.out.println("나이: " + p1.getAge());

		p1.setAge(-17);
		System.out.println("나이: " + p1.getAge());
		
		System.out.println("--------------------------------------------------------------------");
	
		User user1 = new User(1, "gildong", "gildong0000");
		System.out.println("유저아이디: " + user1.getUserId());
		System.out.println("유저넘버: " + user1.getUserNo());
		System.out.println("유저패스워드: " + user1.getPassword());
		
		System.out.println("--------------------------------------------------------------------");
		user1.setPassword("123qwe");
		user1.setUserId("sjy");
		user1.setUserNo(800109);
		System.out.println("유저아이디: " + user1.getUserId());
		System.out.println("유저넘버: " + user1.getUserNo());
		System.out.println("유저패스워드: " + user1.getPassword());

	}
}
