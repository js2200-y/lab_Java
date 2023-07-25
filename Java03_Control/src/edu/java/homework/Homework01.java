package edu.java.homework;

import java.util.Random;
import java.util.Scanner;

public class Homework01 {

	public static void main(String[] args) {
		// 가위바위보 게임
		// 가위-0, 바위-1, 보-2
		
		// 컴퓨터의 가위/바위/보는 (정수) 난수로 만듦.
		Random random = new Random();
		int computer = random.nextInt(3);
		
		
		System.out.println("가위/바위/보 게임");
		System.out.println("-----------------");
		System.out.println("[0] 가위");
		System.out.println("[1] 바위");
		System.out.println("[2] 보");
		System.out.println("-----------------");
		System.out.print("선택 >>> ");
	
		Scanner scanner = new Scanner(System.in);
		int user = scanner.nextInt();
		
		System.out.println("computer("+ computer +") : user(" +user + ")");
		if ( user == 0 ) { // 사용자 : 가위
			if (computer == 0) { // 컴 : 가위
				System.out.println("비김");
			} else if (computer == 1) { // 컴 : 바위
				System.out.println("컴퓨터 승");
			} else { // 컴 :보
				System.out.println("사용자 승");
			}
		} else if ( user == 1 ) { // 사용자 : 바위
			if (computer == 0) { // 컴 : 가위
				System.out.println("사용자 승");
			} else if (computer == 1) { // 컴 : 바위
				System.out.println("비김");
			} else { // 컴 :보
				System.out.println("컴퓨터 승");
			}
			
		} else { // 사용자 : 보
			if (computer == 0) { // 컴 : 가위
				System.out.println("컴퓨터 승");
			} else if (computer == 1) { // 컴 : 바위
				System.out.println("사용자 승");
			} else { // 컴 :보
				System.out.println("비김");
			}
			
		}
	
		// 방법 2:
		if (user == computer) { // 비기는 경우
			System.out.println("비김");
		} else if ( user == 0) { // 사용자: 가위
			if (computer == 1) { // 컴:바위
				System.out.println("컴퓨터 승");
			} else { // 컴 : 보
				System.out.println("사용자 승");
			}
		} else if ( user == 1) { // 사용자 : 바위
			if (computer == 0) { // 컴: 가위
				System.out.println("사용자 승");
			} else { // 컴:보
				System.out.println("컴퓨터 승");
			}
		} else { // 사용자 : 보
			if (computer == 0) { // 컴:가위
				System.out.println("컴퓨터 승");
			} else { //컴 :바위
				System.out.println("사용자 승");
			}
		}
		
		// 방법 3:
		if (user == computer) { //비긴 경우
			System.out.println("비김");
		} else if ((user == 0 && computer==2) // 사용자(가위): 컴(보)
				|| (user == 1 && computer==0) // 사용자(바위): 컴(가위)
				|| (user == 2 && computer==1)) { // 사용자(보) : 컴(바위)
			System.out.println("사용자 승");
		} else { // 사용자가 진 경우 (컴퓨터가 이긴 경우)
			System.out.println("컴퓨터 승");
		}
		
		
		// 방법 4:
		int diff = user - computer;
		if ( diff == 0 ) {
			System.out.println("비김");
		} else if ( (diff == -2) || (diff == 1)) {
			System.out.println("사용자 승");
		} else {
			System.out.println("컴퓨터 승");
		}
		
		
		}

}
