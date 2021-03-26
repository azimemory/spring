package com.kh.toy.common.exception.handler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kh.toy.common.exception.CustomException;

//컨트롤러의 공통관심사를 작성하는 클래스
@Controller
@ControllerAdvice(basePackages = {"com.kh.toy"})
public class ExceptionController {
	@ExceptionHandler(CustomException.class)
	public String serviceException(CustomException e, Model model) {
		model.addAttribute("msg", e.error.msg);
		model.addAttribute("url", e.error.url);
		return "common/result";
	}
}
