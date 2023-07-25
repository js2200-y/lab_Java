package edu.java.inheritance06;

import java.util.Objects;

public class User {
	//필드
	private String userId;
	private String password;
	
	
	//생성자 : (1)기본생성자 (2)argument 2개를 갖는 생성자
	public User() {	}
	public User(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}
	//getter & setter
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	// toString() override: "User(userId = ....., password=....)"
	@Override
	public String toString() {
		return "User (userId=" + userId + ", password=" + password + ")";
	}
	//hashCode() override
	// equals()의 리턴값이 true이면 hashCode()의 리턴 값이 같아야함~!
	@Override
	public int hashCode() {
//		return Objects.hash(userId);
		if(this.userId == null) {
			return 0;
		} else {
			return this.userId.hashCode();
		}
	}
	// equals() override: 두 객체의 userId가 같으면 true, 그렇지 않으면 false
	@Override
	public boolean equals(Object obj) {
	boolean result = false;
	if(obj instanceof User) {
		User other = (User) obj;
		if(this.userId !=null && this.userId.equals(other.userId)) { 
			result = true;
		}
//		result = (this.userId == other.userId); 문자가 같더라도 생성된 객체의 주소가 다르면 false출력됨.
	}
	return result;
	}

}
