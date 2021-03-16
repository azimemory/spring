package com.spring.mybatis.mybatis;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.spring.mybatis.member.model.vo.Member;

@Mapper
public interface MybatisMapper {
	
	@Select("select * from tb_member where user_id = #{userId}")
	Member selectOneTest(String userId);
	
	@Select("select * from member")
	Member selectListTest();
	
	@Insert("insert into member(user_id,password,tell,email) values(#{userId},#{password},#{tell},#{email})")
	int insertTest(Member member);
	
	@Update("update member " + 
			"		set password = #{password}" + 
			"		where user_id = #{userId}")
	int updateTest(Member member);
	
	@Delete("delete from member where user_id = #{userId}")
	int deleteTest(String userId);
	
	
	@Insert("insert into rent_master" + 
			"		 (rm_idx,user_id,title,rent_book_cnt)" + 
			"		  values(SC_RM_IDX.nextval,#{userId},#{title},#{rentBookCnt})")
	int insertRentInfo(Map<String,String> rentInfo);
	
	void insertRentBookInfo(String bIdx);
	
	Map<String,String> selectIfTest(Map<String,String> command);
	
	Map<String,String> selectChooseWhenTest();
	
	int insertForeachTest(Map<String,Object> command);
	
	int updateSetTagTest(Member member);
	
	Map<String,String> selectWhereTagTest(Map<String,Object> command);
	
	Map<String,Object> selectRentbookinfo(Map<String,String> command);
}
