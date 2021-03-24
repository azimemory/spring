package configuration;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("configuration/applicationContext.xml");
		
		Book book = context.getBean("book",Book.class);
		Date date = context.getBean("date",Date.class);
		
		System.out.println(book);
		System.out.println(date);
		
		
		
		
		
		
		
		
		
		
		
	}
}
