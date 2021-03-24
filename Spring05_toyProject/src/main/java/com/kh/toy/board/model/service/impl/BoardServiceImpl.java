package com.kh.toy.board.model.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.kh.toy.board.model.repository.BoardRepository;
import com.kh.toy.board.model.service.BoardService;
import com.kh.toy.board.model.vo.Board;
import com.kh.toy.common.code.ErrorCode;
import com.kh.toy.common.exception.CustomException;
import com.kh.toy.common.util.file.FileUtil;
import com.kh.toy.common.util.file.FileVo;
import com.kh.toy.common.util.paging.Paging;

@Service
public class BoardServiceImpl implements BoardService{
	
	private BoardRepository repo;
	
	public BoardServiceImpl(BoardRepository repo) {
		this.repo = repo;
		
		if(this.repo instanceof BoardRepository) {
			System.out.println("BoardRepository");
		}
		
		System.out.println(this.repo.getClass());
	}
	
	@Override
	public void insertBoard(Board board, List<MultipartFile> files) {
		if(repo.insertBoard(board) == 0) {
			throw new CustomException(ErrorCode.IB01);
		};
		
		if(!(files.size() == 1
			&& files.get(0).getOriginalFilename().equals(""))) {
			//파일업로드를 위해 FileUtil.fileUpload() 호출
			List<FileVo> filedata = new FileUtil().fileUpload(files);
			for(FileVo f : filedata) {
				if(repo.insertFile(f) == 0) {
					throw new CustomException(ErrorCode.IF01);
				};
			}
		}
	}

	@Override
	public Map<String, Object> selectBoardList(int currentPage) {
		 Map<String, Object> commandMap = new HashMap<String, Object>();
		
		 //페이징 처리를 위한 객체 생성
		 Paging p = Paging.builder()
				 	.cntPerPage(5)
				 	.currentPage(currentPage)
				 	.blockCnt(5)
				 	.total(repo.selectContentCnt())
				 	.type("board")
				 	.build();
		 //현재 페이지에 필요한 게시물 목록
		 List<Board> blist = repo.selectBoardList(p);
		 
		 if(blist == null) {
			 throw new CustomException(ErrorCode.SB01);
		 }
		 
		 commandMap.put("blist", blist);
		 commandMap.put("paging", p);
		 return commandMap;
	}

	@Override
	public Map<String, Object> selectBoardDetail(String bdIdx) {
		Map<String,Object> commandMap = new HashMap<String, Object>();
		
		Board board = repo.selectBoardDetail(bdIdx);
		List<FileVo> files = repo.selectFileWithBdIdx(bdIdx);
		
		if(board == null) {
			throw new CustomException(ErrorCode.SB01);
		}else if(files == null) {
			throw new CustomException(ErrorCode.SF01);
		}
		
		commandMap.put("board",board);
		commandMap.put("files",files);
		return commandMap;
	}

	@Override
	public void deleteFileByFIdx(String fIdx) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateBoard(Board notice, List<MultipartFile> files) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteBoard(String bdIdx) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteFileWithBoard(String bdIdx) {
		// TODO Auto-generated method stub
	}

	@Override
	public void test() {
		System.out.println("test");
	}
}
