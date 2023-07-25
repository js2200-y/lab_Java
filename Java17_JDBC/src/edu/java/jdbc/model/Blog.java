package edu.java.jdbc.model;

import java.time.LocalDateTime;

// MVC 아키텍처에서 Model에 해당하는 클래스
// 데이터베이스에서 정의된 테이블의 모양을 자바 클래스로 선언하기 위해서
// 테이블의 컬럼들을 클래스의 필드로 선언.

public class Blog {
	// 테이블 이름과 컬럼의 이름들을 상수로 정의.
	public interface Entity { 
		String TBL_NAME = "BLOGS";
		String COL_ID = "ID";
		String COL_TITLE = "TITLE";
		String COL_CONTENT = "CONTENT";
		String COL_AUTHOR = "AUTHOR";
		String COL_CREATE_TIME = "CREATE_TIME";
		String COL_MODIFIED_TIME = "MODIFIED_TIME";
	}
	// 필드
	private Integer id; // 글 번호. primary key
	private String title; // 글 제목.
	private String content; // 글 내용.
	private String author; // 글 작성자 아이디.
	private LocalDateTime createTime; // 글 최초 작성 시간.
	private LocalDateTime modifiedTime; // 글 수정 시간.
	
	 // 생성자
	public Blog () { }

	public Blog(Integer id, String title, String content, String author, LocalDateTime createTime,
			LocalDateTime modifiedTime) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.createTime = createTime;
		this.modifiedTime = modifiedTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	
	@Override
	public String toString() {
		return String.format("Blog(id=%d, title=%s, content=%s, author=%s, createdTime=%s, modifiedTime=%s)",
				id, title, content, author, createTime, modifiedTime);
	}
	
	
}
