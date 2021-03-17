package com.kh.toy.member.model.repository;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kh.toy.member.model.vo.Member;

@Mapper
public interface MemberRepository {
	
	@Insert("insert into member	(user_id, password, email, tell)"
			+ "	values(#{userId},#{password},#{email},#{tell})")
	int insertMember(Member member);
	
	@Select("select * from member"
			+ "	where user_id=#{userId} and is_leave = 0")
	Member selectMemberById(String userId);
	
	@Select("select count(*) from member where email = #{email}")
	int selectMemberByEmail(String email);
	
	@Select("select count(*) from member where tell = #{tell}")
	int selectMemberByTell(String tell);
	
	int updateMember(Member member);
	
	@Update("update member set is_leave = 1	"
			+ "where user_id = #{userId}")
	int updateMemberToLeave(String userId);
	
}
