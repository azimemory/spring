package com.kh.toy.common.code;

public enum ErrorCode {

	SM01("회원정보를 조회하는 도중 에러가 발생하였습니다.","/member/login"),
	SM02("아이디나 패스워드가 틀렸습니다.","/member/login"),
	IM01("회원정보를 입력하는 도중 에러가 발생하였습니다.","/member/join"),
	UM01("회원정보 수정 중 에러가 발생하였습니다."),
	DM01("회원정보 삭제 중 에러가 발생하였습니다."),
	IB01("게시판 정보를 입력하는 중 에러가 발생하였습니다."),
	SB01("게시판 정보를 조회하는 중 에러가 발생하였습니다."),
	IF01("파일 정보를 입력하는 중 에러가 발생하였습니다."),
	SF01("파일 정보를 조회하는 중 에러가 발생하였습니다."),
	AUTH01("접근 권한이 없는 페이지 입니다."),
	MAIL01("이메일 발송 중 에러가 발생하였습니다."),
	AUTH02("이미 만료된 인증입니다."),
	HTTP01("HTTP 통신 중 에러가 발생하였습니다."),
	CD_404("존재하지 않는 경로입니다.");

	public String errMsg;
	public String url = "/index";
	
	//에러 발생 시 index로 이동
	ErrorCode(String errMsg){
		this.errMsg = errMsg;
	}
	
	//에러 발생 시 지정한 페이지로 이동
	ErrorCode(String errMsg,String url){
		this.errMsg = errMsg;
		this.url = url;
	}
}
