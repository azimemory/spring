package com.kh.spring.member.model.dto;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class MemberAccount extends User{
	
	private static final long serialVersionUID = -7817712196075581742L;
	private Member member;
	
	public MemberAccount(Member member) {
		super(member.getUserId(), member.getPassword(), List.of(new SimpleGrantedAuthority(member.getGrade())));
		this.member =  member;
	}
	
	public static Member getAuthenticatedMember() {
		if(!SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) throw new RuntimeException("사용자 인증정보가 없습니다.");
		MemberAccount m = (MemberAccount)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return m.getMember();
	}
	
	public Member getMember() {
		return member;
	}
	
	public String getPassword() {
		return member.getPassword();
	}
	
	public String getEmail() {
		return member.getEmail();
	}

	public String getTell() {
		return member.getTell();
	}
	
	public String getGrade() {
		return member.getGrade();
	}
	
	
	
	
	
	
	
}
