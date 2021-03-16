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
	int insertMember(Map<String,String> member);
	
	@Select("select * from member"
			+ "	where user_id=#{userId} and is_leave = 0")
	Member selectMember(String userId);
	
	int updateMember(Member member);
	
	@Update("update member set is_leave = 1	"
			+ "where user_id = #{userId}")
	int updateMemberToLeave(String userId);
	
	@Select("select * from member where user_id = #{userId}")
	Member selectMemberById(String userId);
	
	
	
	
	
}
