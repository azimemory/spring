package componentScan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {
	public static void main(String[] args) {
		ApplicationContext context
		= new ClassPathXmlApplicationContext("componentScan/applicationContext.xml");
	
		User user = (User)context.getBean("user");
		System.out.println(user);
	
	}
}
