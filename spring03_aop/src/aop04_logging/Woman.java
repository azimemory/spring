package aop04_logging;

import org.springframework.stereotype.Component;

@Component
public class Woman implements Developer{

	@Override
	public String develop(String lang) { 
		return lang + " 프로그래밍 시작한다.";
	}

	@Override
	public String play(String game) {
		//int zerroError = 10/0;
		return game + "을 하고 논다.";
	}
}
