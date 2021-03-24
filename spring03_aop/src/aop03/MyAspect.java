package aop03;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect //해당 클래스를 Advisor로 만들어주는 어노테이션
public class MyAspect{
	
	@Before("execution(* aop03.*.*(..))")
	public void before(){
		System.out.println("출근 카드를 찍는다.");
	}
	
	@After("execution(* aop03.*.*(..))")
	public void after(){
		System.out.println("집에 간다.");
	}
	
	@AfterThrowing(pointcut = "execution(* aop03.*.*(..))"
			, throwing = "exception") //타깃객체의 메서드 수행 도중 발생한 예외를 받을 변수명 세팅
	public void afterThrowing(Exception exception) {
		System.out.println(exception.getCause());
		System.out.println("쉬는 날이었다.");
	}
	
	@AfterReturning(pointcut = "execution(* aop03.*.*(..))"
			, returning = "res")
	public void afterReturning(Object res) {
		System.out.println("반환값 : " + res);
	}
	
	
	
	
	
	
	
	
	
}
