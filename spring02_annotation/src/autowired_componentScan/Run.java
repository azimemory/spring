package autowired_componentScan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("autowired_componentScan/applicationContext.xml");
		
		Developer dev = context.getBean("dev",Developer.class);
		System.out.println("lecture를 가진 dev : " +  dev);
		System.out.println("dev 의 직업은 : " + dev.getJobInfo());
		
		Lecture lec = context.getBean("lecture",Lecture.class);
		System.out.println("lec 의 직업은 : " + lec.getJobInfo());
		System.out.println(lec);
	}
}
