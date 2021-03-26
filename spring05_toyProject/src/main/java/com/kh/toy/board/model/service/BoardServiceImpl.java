package com.kh.toy.board.model.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.kh.toy.board.model.repository.BoardRepository;
import com.kh.toy.board.model.vo.Board;
import com.kh.toy.common.code.ErrorCode;
import com.kh.toy.common.exception.ToAlertException;
import com.kh.toy.common.util.file.FileUtil;
import com.kh.toy.common.util.file.FileVo;
import com.kh.toy.common.util.paging.Paging;

@Service
public class BoardServiceImpl implements BoardService{
	
	private final BoardRepository boardRepository;
	
	public BoardServiceImpl(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}

	@Override
	public Map<String, Object> selectBoardList(int page) {
		Paging paging = Paging.builder()
				.cuurentPage(page)
				.blockCnt(5)
				.cntPerPage(10)
				.type("board")
				.total(boardRepository.selectContentCnt())
				.sort("bd_idx")
				.direction("desc")
				.build();
		
		Map<String,Object> commandMap = new HashMap<String,Object>();
		commandMap.put("paging", paging);
		commandMap.put("boardList", boardRepository.selectBoardList(paging));
		return commandMap;
	}

	@Override
	public void insertBoard(Board board, List<MultipartFile> files) {
		FileUtil fileUtil = new FileUtil();
		
		try {
			List<FileVo> fileInfo = fileUtil.fileUpload(files);
			boardRepository.insertBoard(board);
			
			for (FileVo fileVo : fileInfo) {
				boardRepository.insertFile(fileVo);
			}
			
		} catch (IllegalStateException | IOException e) {
			throw new ToAlertException(ErrorCode.IB01, e);
		}
	}

	@Override
	public Map<String, Object> selectBoardDetail(String bdIdx) {
		Board board = boardRepository.selectBoardWithBdIdx(bdIdx);
		List<FileVo> files = boardRepository.selectFileWithBdIdx(bdIdx);
		return Map.of("board",board,"files",files);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
