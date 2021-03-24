package com.kh.toy.common.interceptor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kh.toy.common.code.ErrorCode;
import com.kh.toy.common.exception.ToAlertException;

//HandlerInterceptor 를 구현해 인터페이스로 해당 클래스를 활용
public class AuthInterceptor implements HandlerInterceptor{

	//Interceptor
	//dispatcherServlet이 Controller의 메서드를 호출하기전 요청을 가로채서 필요한 선작업을 할 수 있다.
	
	//filter
	//Servlet Container가 Servlet을 호출하기 전에 요청을 가로채는 역할
	//Servlet-Container > filter > dispatcher-servlet  > interceptor > controller
	
	//preHandle : 컨트롤러로 요청이 가기 전에 실행되는 메서드
	// return true : 컨트롤러의 메서드가 실행 됨
	// return false : 컨트롤러의 메서드가 실행 되지 않음
	// object handler : preHandle을 수행하고 수행될 컨트롤러 메서드에 대한 정보
	@Override
	public boolean preHandle(
			HttpServletRequest request
			, HttpServletResponse response
			, Object handler) throws ServletException, IOException{
		
		HttpSession session = request.getSession();
		String[] uriArr = request.getRequestURI().split("/");
		
		if(uriArr.length > 0) {
			switch(uriArr[1]) {
			case "member" :
				switch(uriArr[2]) {
				case "mypage" :
					if(session.getAttribute("userInfo") == null) {
						throw new ToAlertException(ErrorCode.AUTH01);
					}
					break;
				case "joinimpl" :
					//joinimpl 뒤의 패스 변수가 sessionId와 일치하지 않으면 예외처리
					//session에 persistUser 속성값이 존재하지 않으면 예외처리
					if(!uriArr[3].equals(session.getId()) 
							|| session.getAttribute("persistInfo") == null) {
						throw new ToAlertException(ErrorCode.AUTH02);
					}	
					break;
				}
				break;
			}
		}
		return true;
	}
	
	// controller의 handler가 끝나면 처리됨
	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response,
			Object obj, ModelAndView mav)
			throws Exception {
	}

	// view까지 처리가 끝난 후에 처리됨
	@Override
	public void afterCompletion(
			HttpServletRequest request, HttpServletResponse response,
			Object obj, Exception e)
			throws Exception {
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
