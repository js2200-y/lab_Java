package edu.java.jdbc.oracle;

public interface OracleConnect {
	// 인터페이스의 필드는  public static final 만 가능하고, 생략 가능.	
	// localhost: sever ip 
	// 1521: port
	// xe: SID
	
	// 오라클 데이터 베이스 서버 접속 주소(IP, port, SID)
	// localhost: 현재 개인 PC
	String URL = "jdbc:oracle:thin:@192.168.20.11:1521:xe";
	
	// 오라클 데이터베이스 서버 계정
	String USER = "scott";
	
	// 오라클 데이터베이스 서버 계정 비밀번호
	String PASSWORD = "tiger";
	
	
	
	
}
