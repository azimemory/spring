package com.kh.toy.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.kh.toy.board.model.service.BoardService;
import com.kh.toy.board.model.service.impl.BoardServiceImpl;
import com.kh.toy.board.model.vo.Board;
import com.kh.toy.member.model.vo.Member;

import common.code.Code;

@Controller
@RequestMapping("board")
public class BoardController {
	
	private final BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
		
		if(this.boardService instanceof BoardService) {
			System.out.println("BoardServiceImpl");
		}
	}
	
	@GetMapping("detail")
	public String boardDetail() {
		return "board/boardView";
	}
	
	@GetMapping("form")
	public String gotoForm() {
		return "board/boardForm";
	}
	
	//MultiPart 요청이 오면, File은 MultipartFile 객체로 게시글은 Board 객체로 바인드 해준다.
	@PostMapping("upload")
	public String uploadBoard(@RequestParam List<MultipartFile> files
			, @SessionAttribute(name = "userInfo", required = false) Member member
			, Board board) {
		//로그인한 회원이라면
		if(member != null) {
			board.setUserId(member.getUserId()); //게시글 작성자에 해당 회원의 아이디
		}else {
			board.setUserId("test"); //로그인한 회원이 아니라면 비회원으로 등록
		}
		
		boardService.insertBoard(board, files);
		return "redirect:/index";
	}
	
	//파일 다운로드를 진행하기 위해 response의 contentsType을 지정해야한다.
	@PostMapping("download")
	public ResponseEntity<FileSystemResource> downloadFile(
			String ofname, //사용자가 올린 파일 이름
			String savePath //파일경로
			) {
		
		  FileSystemResource resource 
			= new FileSystemResource(Code.UPLOAD + savePath);
		  
		  ResponseEntity<FileSystemResource> response =
				  new ResponseEntity<FileSystemResource>(resource,HttpStatus.OK);
		  
		  response.getHeaders().setContentDisposition(
				  	ContentDisposition.builder("attachement")
				  	.filename(ofname)
				  	.build());
		
		  return response;
	}
}
