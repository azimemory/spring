package bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean/applicationContext.xml");
		
		//ApplicationContext로 부터 해당 아이디를 가진 bean을 반환 받음
		Address lee = (Address)context.getBean("lee");
		System.out.println(lee);
		
		Address hong = (Address) context.getBean("hong");
		System.out.println(hong);
		
		Book harry = (Book)context.getBean("harryPotter");
		System.out.println(harry);
		
		Book flower = (Book) context.getBean("hopeForTheFlower");
		System.out.println(flower);
		
		
		
		
		
		
		
		
	}
}
