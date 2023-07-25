package edu.java.modifier07;

public class Test {
	int x; // 인스턴스 필드
	static int y; // static 필드
	
	// 인스턴스 메서드
	public void printInfo() { //void는 리턴타입
		 System.out.println("-----------------------instance mothod----------------");
		 System.out.println("x= "+ this.x); // this가 의미하는 것은 생성된 객체 인스턴스
		 System.out.println("y= "+ Test.y);
		 // -> 인스턴스 메서드는 static 필드/메서드를 사용할 수 없음.
		 System.out.println("------------------------------------------------------");
	}

	public static void printStaticInfo() { // void는 수식어가 아니라 메서드이름앞에 존재함.
		 System.out.println("----------------------static mothod----------------");
//		 System.out.println("x= "+ x);  // -> static 메서드에서 인스턴스 필드/메서드를 사용 할 수 없기 때문에
		 System.out.println("y= "+ y);
		 System.out.println("------------------------------------------------------");
	}
}
