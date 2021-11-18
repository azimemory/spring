package com.kh.spring.common.interceptor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import com.kh.spring.common.code.ErrorCode;
import com.kh.spring.common.code.member.MemberGrade;
import com.kh.spring.common.exception.HandlableException;
import com.kh.spring.member.model.dto.Member;

public class AuthInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  throws Exception{
		String[] uriArr = request.getRequestURI().split("/");
		
		if(uriArr.length != 0) {
			switch (uriArr[1]) {
				case "member":
					memberAuthorize(request, response, uriArr);
					break;
				case "admin":
					adminAuthorize(request, response, uriArr);
					break;
				case "board":
					boardAuthorize(request, response, uriArr);
					break;
				default:
					break;
			}
		}
		return true;
	}
	
	private void boardAuthorize(HttpServletRequest httpRequest, HttpServletResponse httpResponse, String[] uriArr) {
			HttpSession session = httpRequest.getSession();
			Member member = (Member) session.getAttribute("authentication");
			
			switch (uriArr[2]) {
				case "board-form":
					if(member == null) {
						throw new HandlableException(ErrorCode.UNAUTHORIZED_PAGE);
					}
					break;
				case "upload":
					if(member == null) {
						throw new HandlableException(ErrorCode.UNAUTHORIZED_PAGE);
					}
					break;
			default:
				break;
			}
	}

	private void adminAuthorize(HttpServletRequest httpRequest, HttpServletResponse httpResponse, String[] uriArr) {
		
		Member member = (Member) httpRequest.getSession().getAttribute("authentication");

		//넘어온 인증정보가 관리자인지 사용자인지 판단.
		if(member == null || MemberGrade.valueOf(member.getGrade()).ROLE == "user") {
			throw new HandlableException(ErrorCode.UNAUTHORIZED_PAGE);
		}
		
		MemberGrade adminGrade = MemberGrade.valueOf(member.getGrade());
		if(adminGrade.DESC.equals("super")) return;
		
		switch (uriArr[2]) {
		case "member":
			//회원과 관련된 관리를 수행하는 admin의 등급은 AD01
			if(!adminGrade.DESC.equals("member")) {
				throw new HandlableException(ErrorCode.UNAUTHORIZED_PAGE);
			}
			break;
		case "board":
			//게시판과 관련된 관리를 수행하는 admin의 등급은 AD02
			if(!adminGrade.DESC.equals("board")) {
				throw new HandlableException(ErrorCode.UNAUTHORIZED_PAGE);
			}
			break;
		default:
			break;
		}
	}

	private void memberAuthorize(HttpServletRequest httpRequest, HttpServletResponse httpResponse, String[] uriArr) throws ServletException, IOException {

		switch (uriArr[2]) {
		case "mypage":
			if(httpRequest.getSession().getAttribute("authentication") == null) {
				throw new HandlableException(ErrorCode.AUTHENTICATION_FAILED_ERROR);
			}
			break;
		default:
			break;
		}
	}
}
