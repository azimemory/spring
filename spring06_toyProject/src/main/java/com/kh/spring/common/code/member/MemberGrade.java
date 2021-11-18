package com.kh.spring.common.code.member;

//enum(enumerated type) : 열거형
//서로 연관된 상수들의 집합
//서로 연관된 상수들을 하나의 묶음으로 다루기 위한 enum만의 문법적 형식과 메서드를 제공해준다.
public enum MemberGrade {
	
	//회원등급코드가 'ME00'이면 등급명은 '일반'이고 연장가능횟수 1회
	//내부적으로 enum은 class이다.
	//ME00("일반",1) -> public static final MemberGrade ME00 = new MemberGrade("일반",1);
	//public이기 때문에 어디에서나 접근이 가능하고, static이기 때문에 언제나 접근이 가능한 인스턴스에
	//등급명과 연장횟수를 저장해두고 getter를 통해서 반환받아 사용한다.
	ME00("일반", "user", 1),
	ME01("성실", "user", 2),
	ME03("우수", "user", 3),
	ME04("vip",  "user", 4),
	
	AD00("super", "admin"),
	AD01("member","admin"),
	AD02("board", "admin");
	
	public final String DESC;
	public final String ROLE;
	public final int EXTENDABLE_CNT;
	
	private MemberGrade(String desc, String role) {
		this.DESC = desc;
		this.ROLE = role;
		this.EXTENDABLE_CNT = 9999;
	}
	
	private MemberGrade(String desc, String role, int extendableCnt) {
		this.DESC = desc;
		this.ROLE = role;
		this.EXTENDABLE_CNT = extendableCnt;
	}
	
}
