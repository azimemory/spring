package com.kh.toy.member.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;

import com.kh.toy.member.model.vo.Member;

@Repository
public class MemberDao {
	
	private final SqlSessionTemplate session;
	
	public MemberDao(SqlSessionTemplate session) {
		this.session = session;
	}
	
	public Member selectMemberById(String userId) {
		return session.selectOne("mapper.member.selectMemberById",userId);
	}
	
	public void insertMember(Map<String,String> member) {
		session.insert("mapper.member.insertMember",member);
	}
	
	public void updateMember(Member member) {
		session.update("mapper.member.updateMember",member);
	}
}
