package com.kh.toy.member.model.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.toy.member.model.vo.Member;

@Mapper
public interface MemberRepository {
	
	@Select("select * from tb_member where user_id = #{userId}")
	Member selectMemberById(String userId);
	
	@Select("select * from tb_member where user_id = #{userId} and is_leave = 0")
	Member selectMemberForAuth(String userId);
	
	@Select("select count(*) from tb_member where email = #{email}")
	int selectMemberByEmail(String email);
	
	@Select("select count(*) from tb_member where tell = #{tell}")
	int selectMemberByTell(String tell);
	
	@Insert("insert into tb_member(user_id,password,email,tell)"
			+ " values(#{userId},#{password},#{email},#{tell})")
	int insertMember(Member member);
}
