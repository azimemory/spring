package com.spring.mybatis.member.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.spring.mybatis.member.model.vo.Member;

@Mapper
public interface MemberMapper {
	
	@Select("select * from member where user_Id = #{userId}")
	public Member selectMemberById(String userId);
	
	//namespace의 값이 MemberMapper와 동일한 xml mapper에서 아이디가 메서드명인 tag의 쿼리를 실행하고 반환해준다. 
	//interface mapper는 동적쿼리를 작성하기 힘들고(자동완성 지원 안됨), resultMap 등을 사용하기 힘들기 때문에 
	//복잡한 쿼리는 xml mapper에 작성한 뒤 인터페이스의 프록시 객체를 통해 호출할 수 있도록 메서드명을 맞춰주는 식으로 활용할 수 있다.
	public Member selectMember(String userId);

}
