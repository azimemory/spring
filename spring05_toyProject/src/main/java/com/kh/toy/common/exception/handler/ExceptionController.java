package com.kh.toy.common.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.kh.toy.common.exception.CustomException;

@Component
@ControllerAdvice(basePackages = {"com.kh.toy","common"})
public class ExceptionController {
	
	Logger logger = LoggerFactory.getLogger(ExceptionController.class);
	
	@ExceptionHandler(CustomException.class)
	public String businessExceptionHandler(CustomException e, Model model) {
		model.addAttribute("msg", e.error.errMsg);
		model.addAttribute("url", e.error.url);
		return "common/result";
	}
	
	//DB에서 에러가 발생하였음으로 응답코드를 500번으로 지정, default 200
	@ResponseStatus(code =HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(DataAccessException.class)
	public String dataAccessExceptionHandler(DataAccessException e, Model model) {
		logger.error(e.getMessage());
		model.addAttribute("msg", "데이터베이스 접근 도중 예외가 발생하였습니다.");
		model.addAttribute("url", "/index");
		return "common/result";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
