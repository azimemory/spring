package aopTest.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {

	@Before("execution(* aopTest.vo.*.getArea(..))")
	public void before() {
		System.out.println("도형의 넓이를 구합니다.");
	}
	
	@After("execution(* aopTest.vo.*.getArea(..))")
	public void after() {
		System.out.println("도형의 넓이를 구했습니다.");
	}
	
	@AfterReturning(pointcut = "execution(* aopTest.vo.*.getArea(..))"
			,returning = "res")
	public void afterReturning(int res) {
		System.out.println("넓이 : " + res);
	}
	
}
