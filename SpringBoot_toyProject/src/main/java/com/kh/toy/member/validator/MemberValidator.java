package com.kh.toy.member.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
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
		
		Pattern pattern = Pattern
				.compile("^(?!.*[ㄱ-힣])(?=.*\\W)(?=.*\\d)(?=.*[a-zA-Z])(?=.{8,})");
		
		if(repo.findById(member.getUserId()).get() != null) {
			errors.rejectValue("userId","error.userId","이미 존재하는 아이디 입니다.");
		}
		
		if(!pattern.matcher(member.getPassword()).find()){
			errors.rejectValue("password","error.password","비밀번호는 숫자,영문자,특수문자 조합의 8글자 이상인 문자열입니다.");;
		}
		
		if(repo.existsByEmail(member.getEmail())) {
			errors.rejectValue("email","error.email","이미 존재하는 이메일 입니다.");
		}
		
		if(repo.existsByTell(member.getTell())) {
			errors.rejectValue("tell","error.tell","이미 존재하는 번호 입니다.");
		}
	}
}
