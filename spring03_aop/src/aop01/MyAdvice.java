package aop01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

//공통관심사를 구현할 클래스는 MethodInterceptor(Advice interface 상속)
@Component
public class MyAdvice implements MethodInterceptor{

	//공통 관심사 작성
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		System.out.println("출근 카드를 찍는다.");
		
		Object res = null;
		
		try {
			//target 객체의 메서드를 호출(위임)
			res = invocation.proceed();
		} catch (Exception e) {
			System.out.println("쉬는 날이었다.");
		}finally {
			System.out.println("집에 간다.");
		}
		
		return res;
	}

	
}
