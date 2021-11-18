package com.kh.spring.common;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Map;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class MailTest {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JavaMailSender mailSender;	
	@Autowired
	RestTemplate restTemplate;
	
	@Test
	public void sendMail() throws MessagingException {
		MimeMessage msg = mailSender.createMimeMessage();
        msg.setFrom("azimemory@gmail.com");
        msg.setRecipients(Message.RecipientType.TO,"azimemory@gmail.com");
        msg.setSubject("메일테스트");
        msg.setSentDate(new Date());
        msg.setText("<h1>이메일테스트입니다.</h1>","utf-8","html");
        
        mailSender.send(msg);
	}
	
	@Test
	public void restTempateGetTest() throws URISyntaxException, JsonMappingException, JsonProcessingException {
		String naverIndex = restTemplate.getForObject("https://www.naver.com", String.class);
		
		HttpHeaders kakaoHeader = new HttpHeaders();
		kakaoHeader.add("Authorization", "KakaoAK eaa7f0a4e6e4902213a99929a969c2f5");
		
		RequestEntity request = RequestEntity.get("https://dapi.kakao.com/v2/search/web?query=java")
				.headers(kakaoHeader)
				.build();
		
		String obj = restTemplate.exchange(request, String.class).getBody();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(obj);		
		
		for (JsonNode jsonNode : root.findValues("url")) {
			logger.debug(jsonNode.asText());
		}
	}
	
	@Test
	public void restTempatePostTest() throws URISyntaxException, JsonMappingException, JsonProcessingException {
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		header.add("X-Naver-Client-Id", "O_PVY28f_ilEO4rr4QS6");
		header.add("X-Naver-Client-Secret", "jtxlGACDlg");
		
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("source", "en");
		body.add("target", "ko");
		body.add("text", "This Map implementation is generally not thread-safe. It is primarily designed for data structures exposed from request objects, for use in a single thread only.");
		
		RequestEntity<MultiValueMap> request = RequestEntity
				.post("https://openapi.naver.com/v1/papago/n2mt")
				.headers(header)
				.body(body);
		
		String obj = restTemplate.exchange(request, String.class).getBody();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(obj);		
		
		for (JsonNode jsonNode : root.findValues("translatedText")) {
			logger.debug(jsonNode.asText());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
