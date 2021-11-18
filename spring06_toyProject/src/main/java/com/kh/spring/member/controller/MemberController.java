package com.kh.spring.member.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.CookieGenerator;

import com.kh.spring.common.code.ErrorCode;
import com.kh.spring.common.exception.HandlableException;
import com.kh.spring.common.validator.ValidatorResult;
import com.kh.spring.member.model.dto.Member;
import com.kh.spring.member.model.service.MemberService;
import com.kh.spring.member.validator.JoinForm;
import com.kh.spring.member.validator.JoinFormValidator;

//1. @Controller : 해당 클래스를 applicatioContext에 bean으로 등록
//                   Controller와 관련된 annotation을 사용할 수 있게 해준다.
//2. @RequestMapping : 어떤 요청 URL과 Controller의 메서드를 매핑할 지 지정
//								클래스 위에 선언할 경우, 해당 클래스의 모든 메서드가 지정된 경로를 상위경로로 가짐
//3. @GetMapping : 어떤 GET방식의 요청 URL과 Controller의 메서드를 매핑할 지 지정
//4. @PostMapping : 어떤 POST방식의 요청 URL과 Controller의 메서드를 매핑할 지 지정
//5. @RequestParam : 요청 파라미터를 컨트롤러 메서드의 매개변수에 바인드
//								단 Content-type이 application/x-www-form-urlEncoded 인 경우에만!
//								FormHttpMessageConverter가 동작
//								@RequestParam 속성  
//								name : 요청파라미터명, 매개변수명과 요청파라미터명이 같은 경우 생략
//								required : 요청파라미터 필수 여부 지정, default :true
//								defaultValue : 요청 파라미터가 전달되지 않은 경우 지정할 기본 값
//6. @RequestBody : 요청 body를 읽어서 자바의 객체에 바인드
//								application/x-www-form-urlEncoded를 지원하지 않는다.
//7. @ModelAttribute : 요청 파라미터를 setter를 사용해서 객체에 바인드, Model객체에 바인드된 객체를 자동으로 저장
//8. @RequestHeader : 요청헤더를 컨트롤러의 매개변수에 바인드
//9. @SessionAttribute : 원하는 session의 속성값을 매개변수에 바인드
//10.@CookieValue : 원하는 cookie의 값을 매개변수에 바인드
//11.@PathVariable : url 템플릿에 담긴 파라미터값을 매개변수에 바인드
//12.@ResponseBody : 메서드가 반환하는 값을 응답body에 작성
//13. Servlet객체를 매개변수에 선언해 주입받을 수 있다.
// (HttpServletRequest, HttpServletResponse, HttpSession)

@Controller
@RequestMapping("member")
public class MemberController {
	
	Logger logger =  LoggerFactory.getLogger(this.getClass());
	
	private MemberService memberService;
	private JoinFormValidator joinFormValidator;
	
	public MemberController(MemberService memberService, JoinFormValidator joinFormValidator) {
		super();
		this.memberService = memberService;
		this.joinFormValidator = joinFormValidator;
	}
	
	// model의 속성중 속성명이 joinForm인 속성이 있는 경우에
	// WebDataBinder의 속성을 초기화
	@InitBinder(value = "joinForm")
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(joinFormValidator);
	}

	@GetMapping("join")
	public void joinForm(Model model){
		model.addAttribute(new JoinForm()).addAttribute("error",new ValidatorResult().getError());
	}
	
	@PostMapping("join")
	public String join(@Validated JoinForm form
						,Errors errors  //Errors 객체는 반드시 검증할 객체의 바로 뒤에 작성
						,Model model
						,HttpSession session
						,RedirectAttributes redirectAttr
			) {
		
		ValidatorResult vr = new ValidatorResult();
		model.addAttribute("error", vr.getError());
		
		if(errors.hasErrors()) {
			vr.addErrors(errors);
			return "member/join";
		}
		
		String token = UUID.randomUUID().toString();
		session.setAttribute("persistUser", form);
		session.setAttribute("persistToken", token);
		
		redirectAttr.addFlashAttribute("message", "회원가입완료를 위한 이메일이 발송되었습니다.");
		
		memberService.authenticateByEmail(form,token);
		return "redirect:/";
	}
	
	@GetMapping("join-impl/{token}")
	public String joinImpl(@PathVariable String token
						,@SessionAttribute(value = "persistToken", required = false) String persistToken
						,@SessionAttribute(value = "persistUser", required = false) JoinForm persistUser
						,HttpSession session
						,RedirectAttributes redirectAttr
			) {
		
		if(!token.equals(persistToken)) {
			throw new HandlableException(ErrorCode.AUTHENTICATION_FAILED_ERROR);
		}
		
		memberService.insertMember(persistUser);
		
		session.removeAttribute("persistToken");
		session.removeAttribute("persistUser");
		redirectAttr.addFlashAttribute("message", "환영합니다. 고객님");
		return "redirect:/member/login";
	}
	
	
	@PostMapping("join-json")
	public String joinWithJson(@RequestBody Member member) {
		logger.debug("member : {}",member.toString());
		return "redirect:/";
	}
	
	//로그인 페이지 이동 메서드
	//메서드명 : login
	@GetMapping("login")
	public void login() {}
	
	//로그인 실행 메서드
	//메서드명 : loginImpl
	//재지정할 경로 : WEB-INF/views/member/mypage.jsp
	//아이디와 password로 받아온 Member 객체를 logger를 사용해 출력
	@PostMapping("login")
	public String loginImpl(Member member, HttpSession session, RedirectAttributes redirectAttr) {
		Member certifiedUser = memberService.authenticateUser(member);
		
		if(certifiedUser == null) {
			redirectAttr.addFlashAttribute("message", "아이디나 비밀번호가 틀렸습니다.");
			return "redirect:/member/login";
		}
		
		session.setAttribute("authentication", certifiedUser);
		return "redirect:/member/mypage";
	}
	
	@GetMapping("mypage")
	public String mypage(@SessionAttribute(name = "authentication") Member certifiedUser
								, @CookieValue(name = "JSESSIONID") String sessionId
								, HttpServletResponse response) {
		
		//JSESSIONID 쿠키 출력
		logger.debug(sessionId);
				
		//Session의 authentication 속성 값 출력
		logger.debug(certifiedUser.toString());
		
		//쿠키 생성 및 응답헤더에 추가
		CookieGenerator cookieGenerator = new CookieGenerator();
		cookieGenerator.setCookieName("testCookie");
		cookieGenerator.addCookie(response, "CookeTest_haha");
		
		return "member/mypage";
	}
	
	@GetMapping("id-check")
	@ResponseBody
	public String idCheck(String userId) {
		
		Member member = memberService.selectMemberByUserId(userId);
		
		if(member == null) {
			return "available";
		}else {
			return "disable";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
