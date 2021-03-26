package com.kh.toy.board.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.toy.board.model.vo.Board;
import com.kh.toy.common.util.file.FileVo;
import com.kh.toy.common.util.paging.Paging;

@Mapper
public interface BoardRepository {
	
	List<Board> selectBoardList(Paging paging);
	
	@Select("select count(*) from tb_board")
	int selectContentCnt();
	
	@Insert("insert into tb_board(bd_idx,title,user_id,content)"
			+ " values('b'||sc_board_idx.nextval,#{title},#{userId},#{content})")
	int insertBoard(Board board);
	int insertFile(FileVo fileVo);
	
	@Select("select * from tb_board where bd_idx = #{bdIdx}")
	Board selectBoardWithBdIdx(String bdIdx);
	
	@Select("select * from tb_file where type_idx = #{bdIdx}")
	List<FileVo> selectFileWithBdIdx(String bdIdx);
}
