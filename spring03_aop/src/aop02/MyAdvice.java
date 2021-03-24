package aop02;

import org.springframework.stereotype.Component;

@Component
public class MyAdvice{
	public void before(){
		System.out.println("출근 카드를 찍는다.");
	}
	
	public void after(){
		System.out.println("집에 간다.");
	}
	
	public void afterThrowing() {
		System.out.println("쉬는 날이었다.");
	}
}
