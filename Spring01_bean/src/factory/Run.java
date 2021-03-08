package factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {
		ApplicationContext context = 
						new ClassPathXmlApplicationContext("factory/applicationContext.xml");
		Weak today = (Weak) context.getBean("factorybean");
		System.out.println("오늘은 " + today.dayInfo() + " 입니다.");
	}
}
