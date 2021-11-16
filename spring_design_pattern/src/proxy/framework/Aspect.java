package proxy.framework;

import java.lang.reflect.InvocationTargetException;

public class Aspect implements Developer{
	
	//자바 Reflection : 클래스에 대한 정보를 조사할 수 있는 기법
	private Developer developer;
	
	public Aspect(String className) {
		try {
			developer = (Developer) Class.forName(className).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void develop() {
		
		System.out.println("출근 카드를 찍는다.");
		
		try {
			developer.develop();
		}catch(Exception e){
			System.out.println("쉬는 날이었다.");
		}finally {
			System.out.println("집에 간다.");
		}
	}
}
