package com.kh.toy.member;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.kh.toy.member.model.vo.Member;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

//가상으로 만들어지는 web.xml을 사용해 테스트환경을 구축
@WebAppConfiguration
//Junit의 실행 방법을 지정
//테스트 때 사용할 가상의 applicationContext를 생성하고 관리해준다.
@RunWith(SpringJUnit4ClassRunner.class)
//가상 applicationContext를 생성할 때 사용할 Spring bean 설정파일의 위치를 지정
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})

public class MemberControllerTest {
	
	 @Autowired
	 WebApplicationContext context;
	
	 private MockMvc mockMvc;
	 
	 //테스트를 수행하기 전에 실행할 메서드
	 @Before
	 public void setup() {
		 this.mockMvc = webAppContextSetup(context).build();
	 }
	
	 @Test
	 public void joinTest() throws Exception {
		 mockMvc
		 .perform(get("/member/join"))
		 .andDo(print());
	 }
	
	@Test
	 public void idCheckTest() throws Exception {
		 mockMvc
		 .perform(get("/member/idcheck")
				 .param("userId", "testUser"))
		 .andDo(print());
	 }
	
	@Test
	
	 public void authenticateEmailTest() throws Exception {
		
		Member member = new Member();
		member.setEmail("azimemory@gmail.com");
		member.setUserId("testUser");
		member.setPassword("1234");
		member.setTell("010-0112-0119");
		
		 mockMvc
		 .perform(post("/member/mailauth")
				 .param("userId", "testUser")
				 .param("password", "1234")
				 .param("email", "azimemory@gmail.com")
				 .param("tell","010-0112-0119")
				 )
		 .andDo(print());
		 
		 mockMvc.perform(
				 get("/member/joinimpl")
				 .sessionAttr("persistInfo", member)
				 )
		 .andDo(print());
		 
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
}
