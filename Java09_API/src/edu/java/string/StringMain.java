package edu.java.string;

import java.util.ArrayList;
import java.util.Arrays;

public class StringMain {

	public static void main(String[] args) {
		// Ex 1. 아래의 주민번호 문자열에서 성별을 표시하는 위치의 문자만 출력.
		String ssn = "991231-1234567";
		System.out.println(ssn.charAt(7));

		String[] array = ssn.split("-");
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[1].charAt(0));
		System.out.println("-------------2번문제-------------------");
		// Ex 2. 아래의 문자열 배열에서 "홍길동" 문자열이 처음 등장하는 인덱스를 출력.
		// 만약에 "홍길동" 문자열이 배열에 없으면 -1을 출력.
		String[] names = { "오쌤", "john", "jane", "홍길동", "허균", "홍길동" };
		// System.out.println(Arrays.asList(names).indexOf("홍길동"));
		int index = -1;
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals("홍길동")) {
				index = i;
				break;
			}
		}
		System.out.println("홍길동 인덱스 = " + index);

		System.out.println("-------------3번문제-------------------");
		// Ex 3. 아래의 문자열 배열에서 5글자 이상인 문자열들을 찾아서 출력.
		String[] languages = { "Java", "SQL", "HTML", "CSS", "JavaScript", "Python" };
//		System.out.println(sizeof(languages));
//		System.out.println(Arrays.asList(languages).st);
		for (String s : languages) {
			if (s.length() >= 5) {
				System.out.print(s + " ");
			}
		}
		System.out.println();
		System.out.println("-------------4번문제-------------------");
		// Ex 4. 아래의 문자열 배열에서 대소문자 구별 없이 "est"가 포함된 문자열들을 찾아서 출력.
		String[] tests = { "TEST", "test", "TeSt", "tEST", "테스트" };
		System.out.println("TeSt".toLowerCase());
		System.out.println("TeSt".toUpperCase());
		System.out.println("test".contains("est"));
		for (String s : tests) {
			if (s.toLowerCase().contains("est")) {
				System.out.println(s + " ");
			}
		}
		System.out.println();
//		String searchText = "est";
		int sw = 0;
		for (int i = 0; i < tests.length; i++) {
			if (tests[i].toLowerCase().indexOf("est") >= 0) {
				System.out.println(tests[i]);
				sw = 1;
			}
		}
		System.out.println("-------------5번문제-------------------");
		// Ex 5. 아래의 "YYYY-MM-DD" 형식의 날q1짜 문자열에서 연/월/일 정보를 각각의 int타입 변수에 저장하고 출력.
		String date = "2023-03-22";
		String[] dateStrings = date.split("-");
		int year = Integer.parseInt(dateStrings[0]);
		int month= Integer.parseInt(dateStrings[1]);
		int day= Integer.parseInt(dateStrings[2]);
		System.out.println("year: " + year);
		System.out.println("month: " + month);
		System.out.println("day: " + day);
	}
}
