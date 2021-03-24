package autowired_configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Rent {
	
	//@Autowired : ApplicationContext 등록된 bean 중에서 어노테이션이 적용된 변수와
	//			  타입이 일치하는 bean을 찾아서 의존성 주입을 해준다.
	//			  ApplicationContext에 같은 타입의 bean이 두 개 이상 있을 경우 예외가 발생
	//			  @Qualifier 어노테이션과 함께 사용하여, 타입 대신 name을 기준으로 빈을 탐색하게끔 할 수 있다.
	@Autowired
	@Qualifier("comicBook")
	private Book rentBook;
	
	public Rent() {
		
	}

	@Override
	public String toString() {
		return "Rent [rentBook=" + rentBook + "]";
	}
}
