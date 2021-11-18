package com.kh.spring.member.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.kh.spring.member.model.repository.MemberRepository;

@Component
public class JoinFormValidator implements Validator{
	
	private final MemberRepository memberRepository;

	public JoinFormValidator(MemberRepository memberRepository) {
		super();
		this.memberRepository = memberRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(JoinForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		JoinForm form = (JoinForm) target;
		
		//1. 아이디 존재 유무
		if(memberRepository.selectMemberByUserId(form.getUserId()) != null ) {
			errors.rejectValue("userId", "err-userId", "이미 존재하는 아이디 입니다.");
		}
		
		//2. 비밀번호가 8글자 이상, 숫자 영문자 특수문자 조합인 지 확인
		if(!Pattern.matches("(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Zㄱ-힣0-9]).{8,}", form.getPassword())) {
			errors.rejectValue("password", "err-password", "비밀번호는 숫자 영문자 특수문자 조합인 8글자 이상의 문자열입니다.");
		}
		
		//3. 전화번호가 숫자로만 이루어져 있는 지 확인
		if(!Pattern.matches("\\d{9,11}", form.getTell())) {
			errors.rejectValue("tell", "err-tell", "전화번호는 9~11자리의 숫자입니다.");
		}
	}

	
	
	
	
	
	
	
	
}
