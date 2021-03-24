package aop02;

import org.springframework.stereotype.Component;

@Component
public class Child implements Developer{

	@Override
	public void develop() {
		System.out.println("파이썬으로 프로그래밍 시작한다");
	}

	@Override
	public void play() {
		System.out.println("메이플 스토리를 하고 논다.");
	}
}
