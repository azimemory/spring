package com.kh.spring.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
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
	//10.@CookieVariable : 원하는 cookie의 값을 매개변수에 바인드
	//11.@PathVariable : url 템플릿에 담긴 파라미터값을 매개변수에 바인드
	//12.@ResponseBody : 메서드가 반환하는 값을 응답body에 작성
	//13. Servlet객체를 매개변수에 선언해 주입받을 수 있다.
	// (HttpServletRequest, HttpServletResponse, HttpSession)
	
	@GetMapping("/")
	public String index() {
		//Controller 메서드의 return 타입
		
		// void : 해당 메서드가 호출된 url 경로와 같은 위치의 jsp파일로 요청이 재지정
		//			요청 url : /index/index  -> jsp file : WEB-INF/views/index/index.jsp
		// String : jsp 파일의 위치를 지정 -> return "index/index"   jsp file : WEB-INF/views/index/index.jsp
		// ModelAndView : Model 객체 + view(jsp 위치)
		
		return "index";
	}
	
	
	
	
	
	
	
	
	
	
}
