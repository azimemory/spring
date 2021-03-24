package componentScan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("componentScan/applicationContext.xml");
		
		Developer dev = context.getBean("dev",Developer.class);
		System.out.println(dev.getJobInfo());
		
		Lecture lec = context.getBean("lecture",Lecture.class);
		System.out.println(lec.getJobInfo());
	}
}
