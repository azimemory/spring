package com.kh.toy.member.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.kh.toy.member.model.repository.MemberRepository;
import com.kh.toy.member.model.vo.Member;

@Component
public class MemberValidator implements Validator{
	
	private final MemberRepository repo;
	
	public MemberValidator(MemberRepository repo) {
		this.repo = repo;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		//컨트롤러의 파라미터 타입이 Member 일때만 검사
		return Member.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Member member = (Member)target;
		
		if(repo.selectMemberById(member.getUserId()) != null) {
			errors.rejectValue("userId", "이미 존재하는 아이디 입니다.");
		}
		
		if(repo.selectMemberByEmail(member.getEmail()) > 0) {
			errors.rejectValue("email", "이미 존재하는 이메일 입니다.");
		}
		
		
		
	}
}
