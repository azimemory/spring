package com.kh.spring.member.validator;

public class JoinForm {
	
	private String userId;
	private String password;
	private String tell;
	private String email;
	
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
	
	public String getTell() {
		return tell;
	}
	
	public void setTell(String tell) {
		this.tell = tell;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "JoinForm [userId=" + userId + ", password=" + password + ", tell=" + tell + ", email=" + email + "]";
	}
	
	

}
