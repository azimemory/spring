package com.kh.spring.common;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class FileTest {
	
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
	public void downloadTest() throws Exception {
		mockMvc.perform(get("/download")
				.param("originFileName", "httpMessage_jason.pdf")
				.param("renameFileName", "38d0524d-d1d6-4b51-9e1b-50dec12462d6.pdf")
				.param("savePath", "2021/10/26/"))
		.andExpect(status().isOk())
		.andDo(print());
	}

}
