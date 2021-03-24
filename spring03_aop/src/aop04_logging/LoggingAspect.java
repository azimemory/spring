package aop04_logging;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect //해당 클래스를 Advisor로 만들어주는 어노테이션
public class LoggingAspect{
	
	@Before("execution(* aop04.*.*(..))")
	public void argCheck(JoinPoint join){
		System.out.println("----------------logging----------------");
		System.out.println("target : " + join.getTarget().getClass() );
		System.out.println("method : " + join.getSignature());
		
		if(join.getArgs() != null) {
			System.out.println("args : " + Arrays.toString(join.getArgs()));
		}
		
		System.out.println("---------------------------------------");
	}
	
	@AfterReturning(pointcut = "execution(* aop04.*.*(..))"
			,returning = "res")
	public void returnCheck(Object res){
		System.out.println("----------------logging----------------");
		System.out.println("return : " + res);
		System.out.println("---------------------------------------");
	}
}
