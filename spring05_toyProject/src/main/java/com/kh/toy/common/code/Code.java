package com.kh.toy.common.code;

public enum Code {
	
	//DOMAIN("http://www.pclass.com"),
	DOMAIN("http://localhost:9090"),
	EMAIL("killsky2014@naver.com"),
	UPLOAD("C:\\CODE\\afternoon\\G_SPRING\\resources\\upload\\");
	
	public String desc;
	
	Code(String desc){
		this.desc = desc;
	}
	
	public String toString() {
		return desc;
	}
}
