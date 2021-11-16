package proxy.client;

import proxy.framework.Developer;

public class Child implements Developer{

	@Override
	public void develop() {
		
		System.out.println("어린이는 개발을 하지 않습니다.");
		
	}
}
