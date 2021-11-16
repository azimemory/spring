package com.spring.mybatis.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//1. 해당 클래스를 applicationContext에 빈으로 등록
//2. Controller와 관련된 annotation을 사용할 수 있게 해준다.
@Controller
public class MemberController {
	//로깅 객체 생성
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//view를 지정하는 방법
	//1. ModelAndView 객체를 만들어서 setViewName 메서드에 view 경로를 지정하고 객체를 리턴
	//2. view 경로를 반환
	//3. 아무것도 반환하지 않을 경우, 요청 url을 view 경로로 지정
	@GetMapping("member/join")
	public void member() {
		logger.debug("member 메서드 호출");
		logger.warn("나는 경고한다.");
	};
	
	@PostMapping("member/idcheck")
	public void idcheck(String userId) {
		logger.info("사용자가 전달한 파라미터 : " + userId);
	}
}
