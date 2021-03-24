package factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {
		
		ApplicationContext context =
				new ClassPathXmlApplicationContext("factory/applicationContext.xml");
		
		Week today = context.getBean("factorybean",Week.class);
		System.out.println("오늘 요일은 : " + today.dayInfo());
		
	}
}
