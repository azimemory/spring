package com.kh.spring.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kh.spring.member.model.dto.Member;

@Mapper
public interface MybatisRepository {
	
	@Select("select password from member where user_id = #{userId}")
	String selectPasswordByUserId(String userId);
	
	@Select("select * from member where user_id = #{userId}")
	Member selectMemberById(String userId);
	
	List<Map<String, Object>> selectRentAndMemberById(String userId);
	
	List<Map<String, Object>> selectRentDataByUserId(String userId);
	
	@Insert("insert into member(user_Id, password, tell, email) "
			+ "values(#{userId},#{password},#{email},#{tell}) ")
	int insertWithDto(Member member);
	
	@Insert("insert into rent_master(rm_idx,user_id,title,rent_book_cnt)"
			+ "values(sc_rm_idx.nextval,#{member.userId},#{title},#{rentBookCnt})")
	int insertWithMap(Map<String,Object> map);
	
	@Delete("delete from rent_master where user_id = #{userId}")
	int delete(String userId);
	
	@Update("update member set password = #{password} where user_id = #{userId}")
	int update(Member member);
	
	@Update("{call sp_rent_extend(#{rbIdx, mode=IN})}")
	void procedure(String rbIdx);
	
	List<Map<String,Object>> dynamicQueryIf(Map<String,Object> commandMap);
	
	List<Map<String,Object>> dynamicQueryChoose(Map<String,Object> commandMap);
	
	List<Map<String,Object>> dynamicQueryWhereAndForeachTag(Map<String,Object> commandMap);
	
	List<Map<String,Object>> dynamicQueryForeachTagWithList(List<String> userList);
	
	int dynamicQuerySetTag(Member member);
	
	
	
	
	
	
	
}
