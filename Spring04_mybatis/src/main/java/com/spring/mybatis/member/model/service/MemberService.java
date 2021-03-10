package com.spring.mybatis.member.model.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import com.spring.mybatis.member.model.dao.MemberDao;
import com.spring.mybatis.member.model.vo.Member;

@Service
public class MemberService {
	
	private final MemberDao memberDao;
	
	public MemberService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public Member authenticateUser(Member member) {
		Member info = memberDao.selectMemberById(member.getUserId());
		return info;
	}
	
	public Member selectMemberById(String userId){	
		return memberDao.selectMemberById(userId);
	}
		
	public void insertMember(Member member) {
		memberDao.insertMember(member);
	}
	
	public void updateMember(Member member) {
		memberDao.updateMember(member);
	}
}
