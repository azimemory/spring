package configure;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {
		ApplicationContext context 
		= new ClassPathXmlApplicationContext("configure/applicationContext.xml");

		Rent rent = (Rent) context.getBean("rent");
		System.out.println(rent);
	}
}
