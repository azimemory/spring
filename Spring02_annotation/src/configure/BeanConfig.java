package configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//해당 클래스를 bean 설정용 클래스로 사용하겠다는 의미. @Bean 어노테이션 사용가능
//@Bean 인스턴스를 반환하는 메서드 위에 작성, 반환되는 인스턴스를 자동으로 applicationContext에 등록
@Configuration
public class BeanConfig {
	
	//@Bean annotation으로 bean을 등록할 경우 name 속성을 지정하지 않을 경우
	// 메서드 이름으로 bean의 id가 결정된다.
	@Bean(name="book")
	public Book addBook() {
		return new Book("해리포터와 마법사의 돌","조앤 K 롤링","황금가지",700);
	}
	
	@Bean
	public Rent rent() {
		return new Rent();
	}
}
