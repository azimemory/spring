package com.kh.spring.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.member.model.dto.Member;
import com.kh.spring.member.model.repository.MemberRepository;

@Service
public class AdminMemberService {
	
	@Autowired
	private MemberRepository memberRepository;

	public List<Member> selectAllMember() {
		return memberRepository.selectAllMember();
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
