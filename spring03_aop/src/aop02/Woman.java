package aop02;

import org.springframework.stereotype.Component;

@Component
public class Woman implements Developer{

	@Override
	public void develop() {
		System.out.println("자바스크립트 프로그래밍 시작한다.");
	}

	@Override
	public void play() {
		System.out.println("바람의나라를 하고 논다.");
	}
}
