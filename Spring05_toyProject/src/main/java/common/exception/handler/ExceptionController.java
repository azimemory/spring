package common.exception.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import common.exception.CustomException;

//컨트롤러를 보조하는 클래스
@ControllerAdvice(basePackages = {"com.kh.toy, common"})
public class ExceptionController {
	
	@ExceptionHandler
	public void serviceException(CustomException e) {
		
	}

}
