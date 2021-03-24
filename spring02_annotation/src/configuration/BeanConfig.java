package configuration;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//해당 클래스를 bean 설정용 클래스로 만들어주는 어노테이션 -> @Bean 어노테이션 사용가능
@Configuration
public class BeanConfig {
	
	//@Bean : 해당 메서드가 반환하는 인스턴스를 빈으로 자동으로 등록
	//@Bean 어노테이션을 사용할 경우 name 속성값을 지정하지 않으면 
	//      메서드 이름이 bean의 아이디로 지정된다.
	@Bean
	public Book book() {
		return new Book("해리포터","조앤 K 롤링","황금가지",700);
	}
	
	@Bean
	public Date date() {
		return new Date();
	}
	

}
