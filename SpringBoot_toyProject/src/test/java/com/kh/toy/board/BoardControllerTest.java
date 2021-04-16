package com.kh.toy.board;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class BoardControllerTest{
	@Autowired MockMvc mockMvc;
	
	@Test
	public void uploadBoardTest() throws Exception {
		 MockMultipartFile file1 = 
				 new MockMultipartFile("files", "OFN.txt", null, "firstFile".getBytes());
		
		 for (int i = 0; i < 100; i++) {
			 mockMvc.perform(multipart("/board/upload")
					 .file(file1)
					 .contentType(MediaType.MULTIPART_FORM_DATA)
					 .param("title", "게시글 테스트")
					 .param("content", "목객체를 사용한 게시글 테스트 입니다."))
			 .andDo(print());
		}
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

}
