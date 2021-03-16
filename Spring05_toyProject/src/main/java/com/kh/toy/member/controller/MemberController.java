package com.kh.toy.member.controller;

import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.toy.member.model.service.MemberService;
import com.kh.toy.member.model.service.impl.MemberServiceImpl;
import com.kh.toy.member.model.vo.Member;
import com.kh.toy.member.validator.MemberValidator;

import common.code.ErrorCode;
import common.exception.ToAlertException;

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

	//InitBinder : 특정 컨트롤러에서 validator를 사용하고 싶을 경우 지정	
    @InitBinder("member")
    public void initBinder(WebDataBinder webDataBinder) {
    	//webDataBinder : Controller의 파라미터에 데이터를 바인드 해주는 객체
    	//적용 대상
    	//@RequestParam파라미터 
		//@RequestHeader파라미터
		//@CookieValue파라미터
		//@PathVariable파라미터
		//@ModelAttribute파라미터

        webDataBinder.addValidators(memberValidator);
    }
	
	//반환형이 void일 경우 요청온 viewResolver에 등록된 prefix를 기준으로
	//url과 같은 경로에 있는 jsp로 요청을 재지정한다.
	@RequestMapping("join")
	public void join() {}
	
	@GetMapping("idcheck")
	public String confirmId(@ModelAttribute @Valid Member member, Errors errors) {
		if(errors.hasErrors()) {
			return "member/join";
		}
		
		return "index/index";
	}
	
	@PostMapping("mailauth")
	public String authenticateEmail(@RequestParam Map<String, String> persistInfo, HttpSession session, Model model) {
		session.setAttribute("persistUser", persistInfo);
		persistInfo.put("sessionId", session.getId());
		memberService.authenticateEmail(persistInfo);
		
		model.addAttribute("msg", "이메일이 발송되었습니다.");
		model.addAttribute("url","/index");
		
		return "common/result";
	}
	
	//동적 url : joinimpl/ 로 시작하는 모든 요청을 해당 메서드로 받는다.
	//@PathVariable : 동적 url의 패스변수값을 받을 변수 앞에 작성
	@GetMapping("joinimpl/{sessionId}")
	public String joinImpl(@PathVariable("sessionId") String sessionId, HttpSession session, Model model) {
		
		Map<String,String> member = (Map<String,String>)session.getAttribute("persistUser");
		
		if(!sessionId.equals(member.get("sessionId"))) {
			throw new ToAlertException(ErrorCode.AUTH02);
		}
		
		memberService.insertMember(member);
		session.removeAttribute("persistUser");
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
	public String modify(@ModelAttribute Member member, HttpSession session){
		Member userInfo = (Member) session.getAttribute("userInfo");
		member.setUserId(userInfo.getUserId());
		memberService.updateMember(member);
		return "member/mypage";
	}
	
	@GetMapping("leave")
	public String leave(HttpSession session){
		Member userInfo = (Member) session.getAttribute("userInfo");
		memberService.updateMemberToLeave(userInfo.getUserId());
		return "member/mypage";
	}
}
