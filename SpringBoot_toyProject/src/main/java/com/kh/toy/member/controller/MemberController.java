package com.kh.toy.member.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.kh.toy.common.code.ErrorCode;
import com.kh.toy.common.exception.ToAlertException;
import com.kh.toy.member.model.service.MemberService;
import com.kh.toy.member.model.vo.Member;
import com.kh.toy.member.validator.MemberValidator;


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
//@ResponseBody : 응답바디에 직접 데이터를 작성

//webDataBinder : Controller의 파라미터에 데이터를 바인드 해주는 객체
//@RequestParam
//@RequestHeader
//@CookieValue
//@PathVariable
//@ModelAttribute

//HttpEntity : Headers, body, status 를 가지고 있는 HTTP 메세지 관리 객체
//RequetEntity : HttpEntity를 상속, Spring에서 요청과 관련된 정보를 저장하는 Entity
//ResponseEntity : HttpEntity를 상속, Spring에서 응답과 관련된 정보를 저장하는 Entity
//HttpSession : Spring에서 Session과 관련된 작업을 수행하는 객체
// *** HttpServletRequest와 HttpServletResponse 같은 Servlet 객체를 Controller의 파라미터를 통해 전달 받을 수 있다.
//	   Servlet 객체를 통해서 Request와 Response를 관리할 수 있지만, 이왕이면 Spring이 제공해주는 클래스를 사용하는 것이 더 바람직하다.

@Controller
@RequestMapping("member")
public class MemberController {
	
	private final MemberService memberService;
	private final MemberValidator memberValidator;
	
	public MemberController(MemberService memberService
						,MemberValidator memberValidator) {
		this.memberService = memberService;
		this.memberValidator = memberValidator;
	}

	//InitBinder : WebDataBinder를 초기화하는 메서드를 식별하는 주석
	//		value : webDataBinder가 적용될 파라미터 명 또는 Model의 attribute 이름
    @InitBinder("member")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(memberValidator);
    }
	
	//반환형이 void일 경우 요청온 viewResolver에 등록된 prefix를 기준으로
	//url과 같은 경로에 있는 jsp로 요청을 재지정한다.
	@RequestMapping("join")
	public void join() {}
	
	@GetMapping("idcheck")
	@ResponseBody
	public String confirmId(String userId) {
		if(memberService.selectMemberById(userId) != null) {
			return "fail";
		}
		return "success";
	}
	
	@PostMapping("mailauth")
	public String authenticateEmail(@Valid Member persistInfo
					, Errors error //반드시 Errors 변수를 @Valid 변수 바로 뒤에 작성
					, HttpSession session
					, Model model) {
		
		if(error.hasErrors()) {
			return "member/join";
		}
		
		session.setAttribute("persistInfo", persistInfo);
		session.setAttribute("sessionId", session.getId());
		
		memberService.authenticateEmail(persistInfo,session.getId());
		
		model.addAttribute("msg", "이메일이 발송되었습니다.");
		model.addAttribute("url","/index");
		
		return "common/result";
	}
	
	//동적 url : joinimpl/ 로 시작하는 모든 요청을 해당 메서드로 받는다.
	//@PathVariable : 동적 url의 패스변수값을 받을 변수 앞에 작성
	@GetMapping("joinimpl/{sessionId}")
	public String joinImpl(
			@PathVariable("sessionId") String sessionId
									  , HttpSession session
			,@SessionAttribute("persistInfo")Member persistInfo 
									  , Model model) {
		if(!session.getId().equals(sessionId)) {
			throw new ToAlertException(ErrorCode.AUTH02);
		}
		
		memberService.insertMember(persistInfo);
		session.removeAttribute("persistInfo");
		return "member/login";
	}
	
	@GetMapping("login")
	public void login() {}
	
	@PostMapping("loginimpl")
	@ResponseBody
	public String loginImpl(@RequestBody Member authInfo, HttpSession session) {
		Member member = memberService.authenticateUser(authInfo);
		if(member != null) {
			session.setAttribute("userInfo", member);
			return "success";
		}else {
			return "fail";
		}
	}
	
	@GetMapping("logout")
	public void logout() {}	
	
	@GetMapping("mypage")
	public void myPage() {}
	
	@PostMapping("modify")
	public String modify(@ModelAttribute Member updateInfo
						,@SessionAttribute("userInfo") Member userInfo){
		updateInfo.setUserId(updateInfo.getUserId());
		memberService.updateMember(updateInfo);
		return "member/mypage";
	}
	
	@GetMapping("leave")
	public String leave(@SessionAttribute("userInfo") Member member){
		if(member != null) {
			memberService.updateMemberToLeave(member.getUserId());
		}
		return "index/index";
	}
}
