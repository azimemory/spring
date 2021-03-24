package aopTest.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.w3c.dom.css.Rect;

import aopTest.vo.Shape;

public class Run {

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("aopTest/main/applicationContext.xml");
		
		Shape rect = context.getBean("rect",Shape.class);
		Shape tri = context.getBean("tri",Shape.class);
			
		rect.getArea();
		tri.getArea();
	}
}
