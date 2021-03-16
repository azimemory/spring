package common.http;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@WebAppConfiguration

//@RunWith : Junit 프레임워크의 테스트 실행방법을 변경할때 지정
//SpringJUnit4ClassRunner.class : 
//			테스트를 진행할 때 사용할 applicationContext를 만들고 관리한다.
@RunWith(SpringJUnit4ClassRunner.class)

//자동으로 생성되는 applicationContext의 설정파일 위치를 지정
@ContextConfiguration(
		locations= {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})

public class RestTemplateTest {
	
	@Autowired
	private RestTemplate rt;

	@Test
	public void restTemplateTest() {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		header.add("Authorization", "KakaoAK 090218d8cb8b083610cf6e9d96d86215");
		HttpEntity entity = new HttpEntity<>(header);
	
		Map<String,String> uriVariables = new HashMap<>();
		ResponseEntity<Map> re = 
				rt.exchange("https://dapi.kakao.com/v3/search/{type}?query={keyword}"
						, HttpMethod.GET
						, entity
						, Map.class
						,"book"
						,"자바");
		System.out.println(re.getBody());
	}
}
