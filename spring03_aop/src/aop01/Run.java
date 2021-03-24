package aop01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {
		
		ApplicationContext context 
		= new ClassPathXmlApplicationContext("aop01/applicationContext.xml");
		
		Developer man = context.getBean("man",Developer.class);
		Developer woman = context.getBean("woman",Developer.class);
		
		System.out.println(man.getClass());
		System.out.println("man은 Developer의 인스턴스인가? : " + (man instanceof Developer));
		System.out.println("man은 Man의 인스턴스인가? : " + (man instanceof Man));
		
		System.out.println("\n--------------------------------\n");
		man.develop();
		System.out.println("--------------------------------");
		woman.develop();
		
		System.out.println("--------------------------------");
		
		man.play();
		System.out.println("--------------------------------");
		woman.play();
	}
}
