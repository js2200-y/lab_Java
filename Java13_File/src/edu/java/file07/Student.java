package edu.java.file07;

import java.io.Serializable;

public class Student implements Serializable {
	private int id;
	private String name;
	private Score score;
	
	
	public Student() { }


	public Student(int id, String name, Score score) {
		this.id = id;
		this.name = name;
		this.score = score;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Score getScore() {
		return score;
	}


	public void setScore(Score score) {
		this.score = score;
	}


	@Override
	public String toString() {
//		return "Student [id=" + id + ", name=" + name + ", score=" + score + "]";
		return String.format("Student(id=%d, name=%s, score=%s)", id, name, score);
	}
	
	
	
	// TODO : 생성자, getters, setters, toString 학생의 정보를 파일에 쓸수있는 형ㅌ
	// 여러명의 정보를 저장 ArrayList
	
	
	
	
}
