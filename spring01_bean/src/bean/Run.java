package bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {
		
		ApplicationContext context 
			= new ClassPathXmlApplicationContext("bean/applicationContext.xml");
		
		Address lee = (Address)context.getBean("Lee");
		System.out.println(lee);
		
		Book book = context.getBean("flower", Book.class);
		System.out.println(book);
		
		Address hong = context.getBean("hong",Address.class);
		System.out.println(hong);
		

	}
}
