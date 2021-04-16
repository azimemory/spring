package com.kh.toy.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.kh.toy.common.code.ErrorCode;
import com.kh.toy.common.exception.ToAlertException;
import com.kh.toy.common.util.file.FileEntity;
import com.kh.toy.common.util.file.FileUtil;
import com.kh.toy.common.util.jpa.MergeEntityBuilder;
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
				 .currentPage(page.getPageNumber()+1)
				 .total((int)repo.count())
				 .type("board")
				 .build();
		 
		 commandMap.put("blist", blist.getContent());
		 commandMap.put("paging", paging);
		 return commandMap;
	}

	public Board selectBoardDetail(Long bdIdx) {
		return repo.findById(bdIdx).orElseThrow(()-> new ToAlertException(ErrorCode.NON_EXIST_ARTICLE));
	}
	
	public Board findBoardToModify(Long bdIdx, String userId) {
		return repo.findBoardByBdIdxAndUserId(bdIdx,userId);
	}
	
	@Transactional
	public void modifyBoard(Board board, List<Long> delFiles, List<MultipartFile> files, String userId) {
		FileUtil fileUtil = new FileUtil();
		
		//영속성 컨택스트에서 게시글 정보를 받아온다.
		Board boardEntity = repo.findById(board.getBdIdx())
								.orElseThrow(()-> new ToAlertException(ErrorCode.NON_EXIST_ARTICLE));
		
		//board 엔티티에서 사용자가 삭제한 파일 제거 +  파일 삭제
		boardEntity.getFileList().removeIf(file -> {
			if(delFiles != null && delFiles.contains(file.getFlIdx())) {
				fileUtil.deleteFile(file.getFullPath()+file.getRenameFileName());
				return true;
			}
			return false;
		});
		
		List<FileEntity> fileEntitys = fileUtil.fileUpload(files); //수정할 때 추가한 파일 업로드
		boardEntity.getFileList().addAll(fileEntitys); //board 엔티티에 파일내용 추가
		//수정된 게시글 내용 병합
		boardEntity = new MergeEntityBuilder<Board>()
					.entity(boardEntity).vo(board).ignoreJVMDeafultSetting(true).build().get();
	}

	public void deleteBoard(Long bdIdx) {
		Board boardEntity = repo.findById(bdIdx)
							.orElseThrow(()-> new ToAlertException(ErrorCode.NON_EXIST_ARTICLE));
		
		FileUtil fileUtil = new FileUtil();
		for (FileEntity file : boardEntity.getFileList()) {
			fileUtil.deleteFile(file.getFullPath()+file.getRenameFileName());
		}
		
		repo.delete(boardEntity);
	}
}
