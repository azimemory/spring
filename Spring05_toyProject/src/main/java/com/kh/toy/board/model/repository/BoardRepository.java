package com.kh.toy.board.model.repository;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.kh.toy.board.model.vo.Board;

import common.util.file.FileVo;
import common.util.paging.Paging;

@Mapper
public interface BoardRepository{
	
	@Insert("insert into board (bd_idx, user_id, reg_date, title, content)"
			+ "	values(SC_BOARD_IDX.nextval, #{userId}, sysdate, #{title}, #{content})")
	int insertBoard(Board board);
	
	int insertFile(FileVo file);
	
	List<Board> selectBoardList(Paging page);
	
	//전체 게시글 숫자 반환
	@Select("select count(*) from board")
	int selectContentCnt();
	
	@Select("select * from board where bd_idx = #{bdIdx}")
	Board selectBoardDetail(String bdIdx);
	
	@Select("select * from file where f_idx = #{fIdx}")
	FileVo selectFileWithFIdx(String fIdx);
	
	@Select("select * from file where bd_idx = #{bdIdx}")
	List<FileVo> selectFileWithBdIdx(String bdIdx);
	
	@Delete("delete from file where f_idx = #{fIdx}")
	int deleteFileByFIdx(String fIdx);
	
	@Delete("delete from board where bd_idx = #{bdIdx}")
	int deleteBoard(String bdIdx);
	
	@Delete("delete from file "
			+ "where type_idx = #{typeIdx} and type = 'board'")
	int deleteFileWithBoard(String typeIdx);
	
	@Delete("delete from file where f_idx = #{fIdx} ")
	int deleteFile(String fIdx);
	
	@Update("update board set title = #{title}, content = #{content} "
			+ "where bd_idx = #{bdIdx}")
	int updateBoard(Board board);
	
	
	
	
	

}
