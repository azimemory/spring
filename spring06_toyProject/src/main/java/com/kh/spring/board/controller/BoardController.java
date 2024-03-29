package com.kh.spring.board.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring.board.model.dto.Board;
import com.kh.spring.board.model.service.BoardService;
import com.kh.spring.board.model.service.BoardServiceImpl;
import com.kh.spring.common.util.FileUtil;
import com.kh.spring.member.model.dto.Member;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final BoardService boardService;
	
	@GetMapping("form")
	public String boardForm() {
		return "board/board-form";
	}
	
	@PostMapping("upload")
	public String uploadBoard(Board board
								,List<MultipartFile> files
								,@SessionAttribute("authentication") Member member) {
		board.setUserId(member.getUserId());
		boardService.insertBoard(files, board);
		return "redirect:/";
	}
	
	@GetMapping("article")
	public String boardDetail(String bdIdx, Model model) {
		Map<String,Object> commandMap = boardService.selectBoardByIdx(bdIdx);
		model.addAllAttributes(commandMap);
		return "board/board-detail";
	}
	
	@GetMapping("list")
	public String boardList(@RequestParam(defaultValue = "1") int page, Model model) {
		model.addAllAttributes(boardService.selectBoardList(page));
		return "board/board-list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
