package edu.java.loop09;

import java.util.Iterator;
import java.util.Random;

public class LoopMain09 {

	public static void main(String[] args) {
		/*
		 * 문제 1. 아래와 같이 출력하세요.
		 *
		 **
		 ***
		 ****
		 *****
		 */

		for (int x = 1; x <= 5; x++) { // x는 라인수
			for (int y = 1; y <= x; y++) {
				System.out.print('*'); // y는 출력 횟수
			}
			System.out.println();
		}
		System.out.println("\n=============\n");

		int line = 1;
		while (line <= 5) {
			int count = 1;
			while (count <= line) {
				System.out.print('*');
				count++;
			}
			System.out.println();
			line++;

		}
		/*
		 * 문제 2. 아래와 같이 출력하세요.
		 *
		 **
		 ***
		 ****
		 *****
		 ****
		 ***
		 **
		 *
		 */
		System.out.println("\n=============\n");

		for (int x = 1; x <= 5; x++) {
			for (int y = 1; y <= x; y++) {
				System.out.print("*");
			}
			System.out.println();
		}
//		for (int x = 4; x >= 1; x--) {
//			for (int y = 1; y <= x; y++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}

		for (int x = 1; x <= 4; x++) {
			for (int y = 4; y >= x; y--) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("\n=============\n");

		for (int x = 6; x <= 9; x++) {
			for (int y = 4; y >= x - 5; y--) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("\n=============\n");

		for (int x = 1; x <= 9; x++) {
			if (x <= 5) { // *를 하나씩 늘려나감.
				for (int y = 1; y <= x; y++) {
					System.out.print("*");
				}
			} else { // *를 하나씩 줄여나감
				for (int y = 4; y >= x - 5; y--) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		/*
		  문제 3. 주사위 2개를 던졌을 때 나오는 주사위 눈을 (x, y) 형식으로 출력하세요.
		  두 눈의 합이 5가 되면 출력을 멈추세요. 힌트
		  1: Random 타입의 nextInt(start, end) 메서드를 사용.
		  힌트 2 무한 루프: for ( ; ; ) {...}, while (true) {...}
		  출력 결과 예시: (2, 4) (6, 1) (3, 3) (4, 1)
		 */
		System.out.println("\n=============\n");
		
		Random rand = new Random();
//		for (;;) { // 무한 반복문
		while(true) {
			int dice1 = rand.nextInt(6)+1;
			int dice2 = rand.nextInt(1,7); // 1 <= r <7
			System.out.printf("(%d ,%d)\n", dice1,dice2);
			if (dice1 + dice2 == 5) { // 두 눈의 합이 5가 되면
				break;
			}
		}
			
		
		
		

	} // Ctrl + Shift + f : 코드 포맷팅(자동정렬)

}
