package aop02;

import org.springframework.stereotype.Component;

@Component
public class Man implements Developer{

	@Override
	public void develop() { 
		System.out.println("자바 프로그래밍 시작한다.");
	}

	@Override
	public void play() {
		System.out.println("리니지 M을 하고 논다.");
	}
}
