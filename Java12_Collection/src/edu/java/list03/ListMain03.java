package edu.java.list03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListMain03 {

	public static void main(String[] args) {
		// 문자열들을 원소로 갖는 리스트 생성과 동시에 초기화.
		// Arrays.asList(...) - 아규먼트로 전달된 값들을 원소로 갖는 리스트 객체를 생성.
		List<String> subjects = Arrays.asList("Java", "SQL", "HTML", "CSS", "JavaScript", "Servlet", "JSP", "Spring",
				"Python");
		System.out.println(subjects);

		// 리스트 subjects에서 5글자 이상인 문자열들만 저장하는 리스트를 만들고 출력.
		// ArrayList<String> list = new ArrayList<>();
		// 다형성 : SuperType var = new SubType();
		List<String> longWords = new ArrayList<>(); // -> 빈리스트

		Iterator<String> itr = subjects.iterator();
		while (itr.hasNext()) {
			String s = itr.next();
			if (s.length() >= 5) {
				longWords.add(s);
			}
		}
		System.out.println(longWords);

//		for(String s : subjects) {
//			if(s.length() >= 5) {
//				longWords.add(s);
//			}
//		}
//		System.out.println(longWords);

		// 리스트 subjects의 원소들의 글자수를 저장하는 리스트를 만들고 출력.(원소9개)
		List<Integer> wordlengths = new ArrayList<>();
		for (String s : subjects) {
			wordlengths.add(s.length());
		}
		System.out.println(wordlengths);

		// 정수(0, 1)를 저장하는 리스트를 생성.
		List<Integer> codes = Arrays.asList(0, 1, 0, 0, 1, 1);

		// 리스트 codes의 원소가 0이면 "Male". 1이면 "Female"을 원소로 갖는 리스트를 만들고 출력.
		List<String> genders = new ArrayList<>();
		for (Integer s : codes) {
//			if (s == 0) {
//				genders.add("Male");
//			} else {
//				genders.add("Female");
//			}
			genders.add((s == 0) ? "Male" : "Female");
		}
		System.out.println(genders);
	}
}
