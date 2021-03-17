package com.kh.toy.member.model.service;

import java.util.Map;

import com.kh.toy.member.model.vo.Member;

public interface MemberService {
	
	 Member authenticateUser(Member member);
	 Member selectMemberById(String userId);
	 void authenticateEmail(Member member, String sessionId);
	 void insertMember(Member member);
	 void updateMember(Member member);
	 void updateMemberToLeave(String userId);
}
