package com.spring.mybatis.member.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mybatis.member.model.service.MemberService;
import com.spring.mybatis.member.model.vo.Member;

//@Controller : 
//@RequestMapping : 해당 메서드와 매핑시킬 요청 url을 지정, http method 상관없음
//@GetMapping : 해당 메서드와 매핑시킬 요청 url을 지정, Get method만 매핑
//@PostMapping : 해당 메서드와 매핑시킬 요청 url을 지정, Post method만 매핑
//@RequestParam : FormHttpMessageConverter가 동작, 요청 파라미터의 값을 전달할 매개변수 앞에 작성, Map을 사용해 모든 파라미터를 바인드 할 수 있다.
//			속성 >> name : 파라미터명, 매개변수이름과 파라미터명이 같을 경우 생략가능
//				   required : 파라미터 필수여부
//				   defaultValue : 파라미터가 없거나 값이 비었을 경우 세팅할 값
//				   value : @RequestParam("파라미터명") 형태로 사용할 때 쓰이는 name 의 별칭
//@RequestBody : MappingJacksonHttpMessageConverter가 동작, json을 객체로 바인드해준다.
//				MultiValueMap 앞에 붙을 경우 FormHttpMessageConverter 가 메세지를 변환한다.
//@ModelAttribute : FormHttpMessageConverter가 동작, 요청파라미터를 객체에 바인드 시킨 뒤 응답할 model 객체에 추가한다.
//					자바 bean 규약에 따라 생성된 객체여야 가능하며 생략이 가능하다. 
//@ResponseBody : 응답바디에 직접 데이터를 작성

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private final MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
}
