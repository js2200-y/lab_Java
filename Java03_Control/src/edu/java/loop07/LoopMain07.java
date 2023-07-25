package edu.java.loop07;

import java.util.Iterator;

public class LoopMain07 {

	public static void main(String[] args) {
		// 2중 반복문

		for (int dan = 2; dan < 10; dan++) {
			System.out.println("----" + dan + "단---");
			for (int n = 1; n < 10; n++) {
//				System.out.println (dan + " x " + n + " = " + (dan * n));
				System.out.printf("%d X %d = %d\n", dan, n, dan * n);
				// %d - 정수 %f - 실수 %s -문자
			} // end for (n)

		} // end for (dan)

		System.out.println("\n======================\n");
		// while문을 사용한 구구단 출력

		int dan = 2;
		while (dan < 10) {
			System.out.println("----" + dan + "단---");
			int y = 1;
			while (y < 10) {
				System.out.println(dan + " x " + y + " = " + (dan * y));
				y++;
			}
			dan++;
		}

		System.out.println("\n======================\n");

		int x = 2;
		while (x < 10) {
			System.out.println("---" + x + "단 ---");

			// 구구단 출력
			int y = 1;
			while (y < 10) {
				System.out.printf("%d x %d = %d\n", x, y, x * y);
				y++;
			}

			x++;
		}
	}
}