package com.kh.toy.board;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.kh.toy.board.model.repository.BoardRepository;

import common.util.file.FileVo;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations= {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class BoardTest {
	
	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;
	
	@Autowired
	BoardRepository repo;
	
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	public void uploadBoard() throws Exception{
		MockMultipartFile file1 
		= new MockMultipartFile("files","OFM.txt",null,"firstTestFiles".getBytes());
		MockMultipartFile file2 
		= new MockMultipartFile("files","OFM.txt",null,"secondTestFiles".getBytes());
	
		 this.mockMvc.perform(
			 multipart("/board/upload")
			 .file(file1)
			 .file(file2)
			 .contentType(MediaType.MULTIPART_FORM_DATA)
			 .param("title", "목객체게시글테스트")
			 .param("content", "게시글본문")
			 )
			 .andDo(print());
	}
	
	@Test
	public void boardListTest() throws Exception {
		this.mockMvc.perform(
				get("/board/list")
				.queryParam("page", "1"))
				.andDo(print());
	}
	
	@Test
	public void downloadFile() throws Exception{
		String bdIdx = "100027";
		List<FileVo> fileList = repo.selectFileWithBdIdx(bdIdx);
		
		 this.mockMvc.perform(
			 get("/board/download")
			 .contentType(MediaType.APPLICATION_FORM_URLENCODED)
			 .queryParam("originFileName", fileList.get(0).getOriginFileName())
			 .queryParam("renameFileName", fileList.get(0).getRenameFileName())
			 .queryParam("savePath", fileList.get(0).getSavePath())
			 )
			 .andDo(print());
	}
}
