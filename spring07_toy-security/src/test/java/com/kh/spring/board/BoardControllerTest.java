package com.kh.spring.board;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.kh.spring.member.model.dto.Member;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class BoardControllerTest {
	
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
	public void uploadBoard() throws Exception {
		MockMultipartFile file1 = new MockMultipartFile("files", "OFN.txt", null, "OFN01".getBytes());
		MockMultipartFile file2 = new MockMultipartFile("files", "OFN2.txt", null, "OFN02".getBytes());
		
		Member member = new Member();
		member.setUserId("testPV");
		
		mockMvc.perform(multipart("/board/upload")
				.param("title", "게시글테스트메서드")
				.param("content","본문")
				.sessionAttr("authentication", member))
		.andExpect(status().is3xxRedirection())
		.andDo(print());
	}
	
	@Test
	public void boardDetail() throws Exception{
		Member member = new Member();
		member.setUserId("testPV");
		mockMvc.perform(get("/board/board-detail")
				.param("bdIdx", "100024")
				.sessionAttr("authentication", member))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
