package com.kh.toy.common.code;

public enum ErrorCode {
	
	UNAUTHORIZED_PAGE("접근 권한이 없는 페이지 입니다."),
	EXPRIATION_AUTH("이미 만료된 인증입니다."),

	NON_EXIST_ARTICLE("존재하지 않는 게시물입니다."),
	NON_EXIST_USER("존재하지 않는 사용자입니다."),
	NON_EXIST_FILE("존재하지 않는 파일입니다."),
	
	DATABASE_ACCESS_ERROR("데이터베이스와 통신 중 에러가 발생하였습니다."),
	FILE_ACCESS_ERROR("파일 작업 중 에러가 발생하였습니다."),
	MAIL_SENDING_ERROR("이메일 발송 중 에러가 발생하였습니다."),

	HTTP_ERROR("HTTP 통신 중 에러가 발생하였습니다."),
	CODE_500("서버에서 에러가 발생하였습니다."),
	CODE_404("존재하지 않는 경로입니다.");

	public String msg;
	public String url = "/index";
	
	//에러 발생 시 index로 이동
	ErrorCode(String errMsg){
		this.msg = errMsg;
	}
	
	//에러 발생 시 지정한 페이지로 이동
	ErrorCode(String msg,String url){
		this.msg = msg;
		this.url = url;
	}
}
