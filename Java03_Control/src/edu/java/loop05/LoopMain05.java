package edu.java.loop05;

import java.util.Iterator;

public class LoopMain05 {

	public static void main(String[] args) {
		// 1 ~ 10 정수들을 오름차순으로 한 줄에 출력
		for (int i =1;  i<=10; i++) {
		System.out.print(i+" ");

	}
		System.out.println();
		
		// while 반복문
		int n=1;
		while ( n <=10) {
			System.out.print(n+" ");
			n++;
		}
		System.out.println();
		
		// 출력 결과 : 1 3 5 7 9
		
		for (int i=1; i<10; i +=2) {
			System.out.print( i+" ");
			}
		System.out.println();	
		
		n =1;
		while (n < 10) {
			System.out.print(n+" ");
			n +=2;
		}
		System.out.println();
		
		
		n=1;
		while(n < 10) {
			if(n % 2 == 1) {
				System.out.print(n+" ");
				// (1) n++; (무한루프)
				
			}
			
			n++;
		}
		
		}
		
}
