package beanTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("beanTest/applicationContext.xml");
		
	}
}
