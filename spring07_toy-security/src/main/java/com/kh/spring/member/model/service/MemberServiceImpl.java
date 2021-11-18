package com.kh.spring.member.model.service;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.spring.common.code.Config;
import com.kh.spring.common.mail.MailSender;
import com.kh.spring.member.model.dto.Member;
import com.kh.spring.member.model.dto.MemberAccount;
import com.kh.spring.member.model.repository.MemberRepository;
import com.kh.spring.member.validator.JoinForm;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
	
	private final RestTemplate template;
	private final MailSender mailSender;
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = memberRepository.selectMemberByUserId(username);
		if(member == null) throw new  UsernameNotFoundException(username);
		return new MemberAccount(member);
	}
	
	public void insertMember(JoinForm form) {
		form.setPassword(passwordEncoder.encode(form.getPassword()));		
		memberRepository.insertMember(form);
	}

	public Member selectMemberByUserId(String userId) {
		return memberRepository.selectMemberByUserId(userId);
	}

	public void authenticateByEmail(JoinForm form, String token) {
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("mail-template", "join-auth-email");
		body.add("userId", form.getUserId());
		body.add("persistToken", token);
		
		//RestTemplate의 기본 ContentType이 application/json이다.
		RequestEntity<MultiValueMap<String, String>> request = 
				RequestEntity.post(Config.DOMAIN.DESC+"/mail")
				.accept(MediaType.APPLICATION_FORM_URLENCODED)
				.body(body);
		
		String htmlText = template.exchange(request, String.class).getBody();
		mailSender.sendEmail(form.getEmail(), "회원가입을 축하합니다.", htmlText);
	}

	
	
	
}
