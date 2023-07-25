package edu.java.loop03;

public class LoopMain03 {

	public static void main(String[] args) {
		
	for (int n= 1; n <= 100; n++) { 
		 System.out.print (n + "\t");
		 if (n %10 == 0 ) {
			 System.out.println();
		 }
	}
	System.out.println();
	
		
	System.out.println("ㅡㅡㅡㅡㅡㅡ");
	
	for (int x= 1; x < 10; x++) {
//		System.out.println("2 x " + x + " = "+(2*x));
	System.out.printf(" 2 x %d = %d\n",x, 2 * x);
	}

	// System.out.printf(문자열 템플린/포맷, 템플릿을 채울 값들);
	// %d: 정수, %f: 실수, %s:문자열	
	// \n: 줄바꿈(new line), \t:탭(tab)	

	}
	
}
