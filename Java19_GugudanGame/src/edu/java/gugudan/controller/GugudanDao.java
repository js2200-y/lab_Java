package edu.java.gugudan.controller;

import java.util.ArrayList;
import java.util.List;

import edu.java.gugudan.model.GugudanModel;

// MVC아키텍쳐세어 컨트롤러 역할의 인터페이스
// CRUD(create-insert, Read-select, Update, Delete)작업을 DB에서.
// DAO(Data Access Object): 데이터를 사용해서 비지니스 로직(기능)을 수행하는 객체
public interface GugudanDao {

	/**
	 * 연락처 전체 검색
	 * DB Gugudan 테이블에 저장된 연락처 정보를 검색.
	 * 
	 * @return gugudan 타입을 원소로 갖는 리스트
	 */
	List<Gugudan> read(); 

	
	/**
	 * 연락처 정보를 DB gugudan 테이블에 insert
	 * @param gugudan 저장할 이름(name), 전화번호(phone), 이메일(email) 정보 가지고 있는 객체
	 * @return DB테이블에 삽입된 행의 개수
	 */
	int create(Gugudan gugudan);

	/**
	 * Primary key(cid)에 해당하는 연락처 정보를 DB테이블에서 삭제
	 * 
	 * @param cid 삭제할 연락처의 고유키
	 * @return 삭제된 행의 개수
	 */
	int delete(Integer cid); 
	
	
	
	
	
	
	
	
	
}
