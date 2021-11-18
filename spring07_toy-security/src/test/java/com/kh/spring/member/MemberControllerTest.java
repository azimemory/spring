package com.kh.spring.member;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.spring.member.model.dto.Member;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

//가상으로 만들어지는 web.xml을 사용해 테스트환경을 구축
@WebAppConfiguration
//Junit을 실행할 방법
//테스트 때 사용할 가상의 applicationContext를 생성하고 관리
@RunWith(SpringJUnit4ClassRunner.class)
//가상의 applicationContext를 생성할 때 사용할 spring bean 설정파일의 위치를 지정
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class MemberControllerTest {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	//@Before : 테스트 수행 전 실행 될 메서드에 선언
	//@Test : 테스트를 수행 할 메서드
	//@After : 테스트 수행 후 실행 될 메서드에 선언
	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(context).build();
	}
	
	@Test
	public void join() throws Exception {
		mockMvc.perform(post("/member/join")
				.param("userId", "testPPP")
				.param("password", "123qwe!@#")
				.param("email", "azimemory@gmail.com")
				.param("tell", "01000001111"))
		.andExpect(status().is3xxRedirection())
		.andDo(print());
	}
	
	@Test
	public void jacksonTest() throws JsonProcessingException {
		Member member = new Member();
		member.setUserId("testJson");
		member.setPassword("123456");
		member.setEmail("aaa@bbb.com");
		member.setTell("123");
		
		ObjectMapper mapper = new ObjectMapper();
		
		//자바 객체 -> json 문자열
		String memberJson = mapper.writeValueAsString(member);
		logger.debug(memberJson);
		
		//json 문자열 -> 자바 객체
		Member obj = mapper.readValue(memberJson, Member.class);
		logger.debug(obj.toString());
		
		//json 문자열 -> java.util.Map
		Map<String,Object> map = mapper.readValue(memberJson, Map.class);
		logger.debug(map.toString());
	}
	
	@Test
	public void joinWithJson() throws Exception{
		
		Member member = new Member();
		member.setUserId("testJson");
		member.setPassword("123456");
		member.setEmail("aaa@bbb.com");
		member.setTell("010-2222-3333");
		
		ObjectMapper mapper = new ObjectMapper();
		String memberJson = mapper.writeValueAsString(member);
		
		mockMvc.perform(post("/member/join-json")
				.contentType(MediaType.APPLICATION_JSON)
				.content(memberJson))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	public void login() throws Exception {
		mockMvc.perform(post("/member/login")
				.param("userId", "test")
				.param("password", "1234"))
		.andExpect(status().is3xxRedirection())
		.andDo(print());
	}
	
	@Test
	public void mypage() throws Exception {
		Member member = new Member();
		member.setUserId("testJson");
		member.setPassword("123456");
		member.setEmail("aaa@bbb.com");
		member.setTell("010-2222-3333");
		
		mockMvc.perform(get("/member/mypage")
				.cookie(new Cookie("JSESSIONID", "1827391826752980734562934"))
				.sessionAttr("authentication", member))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	public void idCheck() throws Exception {
		mockMvc.perform(get("/member/id-check")
				.param("userId", "test0099"))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	
	
	
	
	
}
