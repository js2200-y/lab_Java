package edu.java.class07;

public class Score {
	// 필드 -  객체의 속성(데이터)
	int java; // 자바 과목 점수
	int sql;  // 0~100점
	int html;
	
	// 생성자 - 객체 속성 초기화
	//(1) 기본 생성자 (2) 모든값을 포함하는 생성자
	
	public Score () {
		
	}
	
	public Score(int java, int sql, int html) {
		this.java = java;
		this.sql = sql;
		this.html = html;
		
	}
	
	// 메서드 - 객체 기능
	// (1) printScore - 세 과목 점수 출력
	// (2) getTotal - 세 과목 총점 리턴
	// (3) getAverage - 세 과목 평균(double) 리턴
	
	public void printScore() {
		System.out.println("java: "+ this.java);
		System.out.println("sql: " + this.sql);
		System.out.println("html: " + this.html);
	}
	
	public int getTotal() {
		return this.java + this.sql + this.html;
	}
	
	public double getAverage() {
		return (double) getTotal() / 3;
		}
	
}

