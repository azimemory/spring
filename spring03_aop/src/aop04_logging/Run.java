package aop04_logging;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {
		
		ApplicationContext context 
		= new ClassPathXmlApplicationContext("aop04/applicationContext.xml");
		
		Developer man = context.getBean("man",Developer.class);
		Developer woman = context.getBean("woman",Developer.class);
		
		System.out.println(man.getClass());
		System.out.println("man은 Developer의 인스턴스인가? : " + (man instanceof Developer));
		System.out.println("man은 Man의 인스턴스인가? : " + (man instanceof Man));
		
		man.develop("루비");
		woman.develop("엘릭서");
		man.play("메이플");
		woman.play("로스트아크");
	}
}
