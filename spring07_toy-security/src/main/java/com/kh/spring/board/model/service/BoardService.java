package com.kh.spring.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.kh.spring.board.model.dto.Board;

public interface BoardService {
	
	void insertBoard(List<MultipartFile> mfs, Board board);
	Map<String, Object> selectBoardByIdx(String bdIdx);
	Map<String,Object> selectBoardList(int page);
	
}
