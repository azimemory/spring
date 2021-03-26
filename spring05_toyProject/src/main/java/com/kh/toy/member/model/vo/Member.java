package com.kh.toy.member.model.vo;

import java.sql.Date;

//TB_MEMBER 테이블의 ROW 정보를 담을 클래스
public class Member {
	
	//MVC2 패턴에서 M은 MODEL을 의미함
	//MODEL은 도메인 객체, 비지니스 로직을 담당하는 SERVICE 객체
	//DBMS에 접근해 데이터를 조회, 수정, 삽입, 삭제하는 DAO 객체
	
	//도메인 객체 : 데이터베이스 테이블에서 조회 해온 한 행(ROW)의 
	//값을 저장하는 용도로 사용하는 객체
	//DOMAIN OBJECT, VALUE OBJECT(VO), DATA TRANSFER OBJECT(DTO)
	//ENTITY, BEAN
	
	//VO가 되기 위한 조건(JAVA BEAN 규약)
	//1. 모든 필드변수는 PRIVATE일 것.(캡슐화)
	//2. 반드시 기본생성자가 존재해야 한다.
	//3. 모든 필드변수는 GETTER/SETTER 메서드를 가져야 한다.
	
	//오라클과 자바의 타입 매핑
	//char, vachar2 -> String
	//date -> java.util.date, java.sql.date
	//number -> int, double
	
	/*   TB_MEMBER 컬럼명
	 *   USER_ID, PASSWORD, EMAIL, GRADE, TELL, REG_DATE
	 * , RENTABLE_DATE, IS_LEAVE
	 */
	
	private String userId;
	private String password;
	private String email;
	private String grade;
	private String tell;
	private Date regDate;
	private Date rentableDate;
	private int isLeave;
	
	public Member() {
		
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getTell() {
		return tell;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getRentableDate() {
		return rentableDate;
	}

	public void setRentableDate(Date rentableDate) {
		this.rentableDate = rentableDate;
	}

	public int getIsLeave() {
		return isLeave;
	}

	public void setIsLeave(int isLeave) {
		this.isLeave = isLeave;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", password=" + password + ", email=" + email + ", grade=" + grade
				+ ", tell=" + tell + ", regDate=" + regDate + ", rentableDate=" + rentableDate + ", isLeave=" + isLeave
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
