package edu.java.contact.ojdbc;

public interface OracleConnect {
	// 인터페이스 필드는 public static final만 가능하고 생략가능~!
	// 노트북에서는 localhost로 변경~!
	// 오라클 데이터베이스 접속 URL
	String URL = "jdbc:oracle:thin:@192.168.20.11:1521:xe";
	
	// 오라클 데이터베이스 접속 계정
	String USER = "scott";
		
	// 오라클 데이터베이스 접속 계정의 비번
	String PASSWORD = "tiger";
	
	
}
