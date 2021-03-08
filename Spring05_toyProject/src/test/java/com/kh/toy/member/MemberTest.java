package com.kh.toy.member;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.kh.toy.member.model.vo.Member;

//시작 전 
// * oracle6 드라이버를 프로젝트 빌드패스에 추가하고 시작할 것.
// * mybatis의 config.xml 파일에서 mapper 경로 확인. mapper resource 경로 앞에 '/'있으면 안된다.

//프로젝트의 web.xml이 아니라 테스트를 위해 
//자동으로 생성되는 가상의 web.xml을 사용하겠다는 의미
@WebAppConfiguration

//@RunWith : Junit 프레임워크의 테스트 실행방법을 변경할때 지정
//SpringJUnit4ClassRunner.class : 
//			테스트를 진행할 때 사용할 applicationContext를 만들고 관리한다.
@RunWith(SpringJUnit4ClassRunner.class)

//자동으로 생성되는 applicationContext의 설정파일 위치를 지정
@ContextConfiguration(
		locations= {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})

public class MemberTest {
	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;

	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	public void loginTest() throws Exception{
		 this.mockMvc.perform(
				 post("/member/loginimpl")
				 .contentType(MediaType.APPLICATION_JSON)
				 .content("{\"userId\":\"test\",\"password\":\"1234\"}"))
				 .andDo(print())
				 .andExpect(content().string("success"));
	}
	
	@Test
	public void modifyTest() throws Exception {
		Member member = new Member();
		member.setUserId("test");
		
		this.mockMvc.perform(post("/member/modify")
				.sessionAttr("userInfo", member)
				.param("password", "1234")
				.param("email","azimemory@naver.com"))
		.andDo(print())
		.andExpect(status().isOk());
	}
	
	
	
}
