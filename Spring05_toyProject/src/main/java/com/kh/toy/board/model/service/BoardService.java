package com.kh.toy.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.kh.toy.board.model.vo.Board;

public interface BoardService {
	
	public void insertBoard(Board board,List<MultipartFile> files);

	public Map<String, Object> selectBoardList(int currentPage, int cntPerPage);

	public Map<String,Object> selectBoardDetail(String bdIdx);

	public void deleteFileByFIdx(String fIdx);

	public void updateBoard(Board notice, List<MultipartFile> files);

	public void deleteBoard(String bdIdx);

	public void deleteFileWithBoard(String bdIdx);
	 
	public void test();

}
