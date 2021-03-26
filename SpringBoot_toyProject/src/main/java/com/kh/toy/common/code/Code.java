package com.kh.toy.common.code;

public enum Code {
	DOMAIN("http://localhost:9797"), //DOMAIN("http://www.pclass.com")
	EMAIL("killsky2014@naver.com"),
	UPLOAD("C:\\CODE\\afternoon\\E_SERVLET\\resources\\upload\\");
	public String desc;
	
	Code(String desc){
		this.desc = desc;
	}
	
	public String toString() {
		return desc;
	}
}
