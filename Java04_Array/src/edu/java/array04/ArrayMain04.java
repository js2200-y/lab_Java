package edu.java.array04;

import java.util.Iterator;
import java.util.Random;

public class ArrayMain04 {

	public static void main(String[] args) {
		// 정수 5개를 저장할 수 있는 배열을 선언.
		int[] numbers = new int[5];

		// 0 이상 9 이하의 정수 난수 5개를 배열에 저장.
		Random rand = new Random();
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rand.nextInt(10);
		}
//		numbers[0] = 난수;
//		numbers[1] = 난수;
//		numbers[2] = 난수;
//		numbers[3] = 난수;

		// 배열의 모든 원소의 합을 계산하고 출력.
		for (int x : numbers) {
			System.out.print(x + " ");
		}
		System.out.println();

		int sum = 0;
//		for (int i = 0; i < numbers.length; i++) {
//			sum += numbers[i]; //sum = sum + numbers[i]
//			System.out.println("sum= " + sum);
//		}
		for (int x : numbers) {
			sum += x;
		}
		System.out.println("sum = " + sum);

//		sum = sum + numbers[0];
//		sum = sum + numbers[1];

		// 배열 원소들의 평균을 double 타입으로 계산하고 출력.
		double average = (double) sum / numbers.length; 
		System.out.println("average= " + average);

		// 배열의 원소들 중 최대값을 찾고 출력. 최대값 변수 선언 int max = arr[0];

		int max = numbers[0]; // 배열의 첫번째 (인덱스 0번 위치의) 원소를 최대값이라고 가정.
		for (int x : numbers) { // 배열 numbers의 모든 원소들을 순회하면서
			if (x > max) { // 배열에서 읽은 값이 max보다 크다면
				max = x; // max의 값을 x로 변경.
			}
		}
		System.out.println("max= " + max);

		// 배열의 원소들 중 최소값을 찾고 출력.

		int min = numbers[0]; //배열이 첫번째 원소를 최소값이라고 가정.
		for (int x : numbers ) { // 배열의 모든 원소를 순서대로 반복하면서,
			if ( x < min ) { // 배열에서 읽은 값이 min보다 작다면
				min = x; // min의 값을 x( 배열에 읽은 더 작은 값)으로 변경.
			}
		}
		System.out.println("min= " + min);
	}
}