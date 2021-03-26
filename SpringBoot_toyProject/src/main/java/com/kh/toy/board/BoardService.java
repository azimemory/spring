package com.kh.toy.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.toy.common.code.ErrorCode;
import com.kh.toy.common.exception.CustomException;
import com.kh.toy.common.util.file.FileEntity;
import com.kh.toy.common.util.file.FileUtil;
import com.kh.toy.common.util.paging.Paging;

@Service
public class BoardService {
	
private BoardRepository repo;
	
	public BoardService(BoardRepository repo) {
		this.repo = repo;
	}
	
	public void insertBoard(Board board, List<MultipartFile> files) {
		if(!(files.size() == 1 && files.get(0).getOriginalFilename().equals(""))) {
			//파일업로드를 위해 FileUtil.fileUpload() 호출
			List<FileEntity> fileEntities = new FileUtil().fileUpload(files);
			board.setFileList(fileEntities);
			board = repo.save(board);
		}
	}

	public Map<String, Object> selectBoardList(PageRequest page) {
		 Map<String, Object> commandMap = new HashMap<String, Object>();
		
		 //현재 페이지에 필요한 게시물 목록
		 Page<Board> blist = repo.findAll(page);
		 Paging paging = Paging.builder()
				 .blockCnt(5)
				 .cntPerPage(page.getPageSize())
				 .currentPage(page.getPageNumber())
				 .total((int)repo.count())
				 .type("board")
				 .build();
		
		 commandMap.put("blist", blist.getContent());
		 commandMap.put("paging", paging);
		 return commandMap;
	}

	public Map<String, Object> selectBoardDetail(Long bdIdx) {
		Map<String,Object> commandMap = new HashMap<String, Object>();
		
		Board board = repo.findById(bdIdx).get();
		commandMap.put("board",board);
		return commandMap;
	}

	public void deleteFileByFIdx(String fIdx) {
		// TODO Auto-generated method stub
	}

	public void updateBoard(Board notice, List<MultipartFile> files) {
		// TODO Auto-generated method stub
	}

	public void deleteBoard(String bdIdx) {
		// TODO Auto-generated method stub
	}

	public void deleteFileWithBoard(String bdIdx) {
		// TODO Auto-generated method stub
	}
}