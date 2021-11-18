package com.kh.spring.member.model.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.kh.spring.member.model.dto.Member;
import com.kh.spring.member.validator.JoinForm;

public interface MemberService  extends UserDetailsService{

	void insertMember(JoinForm form);

	Member selectMemberByUserId(String userId);

	void authenticateByEmail(JoinForm form, String token);
	
	
	
	
}
