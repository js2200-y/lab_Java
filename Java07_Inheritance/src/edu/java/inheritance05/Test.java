package edu.java.inheritance05;

public class Test {
	private int x;
	protected int y;
	
	public Test(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
}


class TestChild extends Test {
	private int z;
	
// 부모 클래스에 기본생성자가 없어서 만들어 줘야함~!
	public TestChild(int x, int y) {
		super(x, y);
		this.z = z;
		// TODO Auto-generated constructor stub
	}
	
	public void printInfo() {
		System.out.printf("x=%d, y=%d, z=%d",this.getX(),this.y, this.z);
		// private : 자기 자신 클래스에서만 직접 사용
		// > 상속하는 하위 클래스에서도 보이지 않음( not visible)
		// protected: 같은 클래스 또는 상속하는 클래스에서 직접 사용가능.
	}
}