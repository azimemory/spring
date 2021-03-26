package com.kh.toy.member.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.toy.common.code.Code;
import com.kh.toy.common.mail.MailSender;
import com.kh.toy.member.model.repository.MemberRepository;
import com.kh.toy.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService{
	
	private final MemberRepository memberRepository;
	
	@Autowired
	private RestTemplate http;
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Override
	public Member selectMemberById(String userId) {
		return memberRepository.selectMemberById(userId);
	}
	
	public void authenticateEmail(Member persistUser, String authPath) {
		
		MultiValueMap<String, Object> body = new LinkedMultiValueMap<String, Object>();
		body.add("userId",persistUser.getUserId());
		body.add("mail-template","temp_join");
		body.add("authPath", authPath);
		
		RequestEntity<Map> request = 
				RequestEntity
				.post(Code.DOMAIN+"/mail")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.body(body);
		
		ResponseEntity<String> response =
				http.exchange(request, String.class);
		
		mailSender.send(persistUser.getEmail(), "회원 가입을 축하합니다.", response.getBody());
	}

	@Override
	public int insertMember(Member member) {
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		return memberRepository.insertMember(member);
	}

	@Override
	public Member authenticateUser(Member member) {
		
		Member userInfo = memberRepository.selectMemberForAuth(member.getUserId());
		if(userInfo == null ||
				!passwordEncoder.matches(member.getPassword(), userInfo.getPassword())) {
			return null;
		}
		
		return userInfo;
	}

	

	
	
	
	
	
	
	
	
	
}
