package common;

import java.awt.PageAttributes.MediaType;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})

public class APITest {
	
	@Autowired
	RestTemplate http;

	@Test
	public void kakaoAPITest() {
		 RequestEntity request = RequestEntity
				 .get("https://dapi.kakao.com/v2/search/vclip?query=아이유")	
				 .header("Authorization", "KakaoAK 090218d8cb8b083610cf6e9d96d86215")
				 .build();
		 
		 ResponseEntity<Map> response = http.exchange(request, Map.class);
		 System.out.println(response.getBody().get("documents"));
	}
	
	
	
	
	
	
	
	
	
}
