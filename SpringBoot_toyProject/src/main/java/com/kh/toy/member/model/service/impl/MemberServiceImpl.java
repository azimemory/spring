package com.kh.toy.member.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.toy.common.code.Code;
import com.kh.toy.common.mail.MailSender;
import com.kh.toy.member.model.repository.MemberRepository;
import com.kh.toy.member.model.service.MemberService;
import com.kh.toy.member.model.vo.Member;


@Service
public class MemberServiceImpl implements MemberService{
	
	private final MemberRepository repo;
	
	@Autowired
	MailSender mail;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	RestTemplate rt;
	
	public MemberServiceImpl(MemberRepository repo) {
		this.repo = repo;
	}
	
	public Member authenticateUser(Member member) {
		Member info = repo.findByUserIdAndIsLeave(member.getUserId(),0);
		
		if(!passwordEncoder.matches(member.getPassword(), info.getPassword())) {
			return null;
		}
		
		return info;
	}
	
	public boolean selectMemberById(String userId){	
		return repo.existsById(userId);
	}
	
	public void authenticateEmail(Member member, String sessionId) {
		//RestTemplate의 기본 Contents-type은 application/json
		//Application/x-www-form-urlencode 형식으로 보낼 때 파라미터는 MultiValueMap<String, String>에 담는다.
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();		
		body.add("mail-template","temp_join");
		body.add("userId",member.getUserId());
		body.add("sessionId",sessionId);
		
		HttpEntity entity = new HttpEntity(body,header);
		ResponseEntity<String> re = rt.exchange(Code.DOMAIN+"/mail", HttpMethod.POST,entity, String.class);
		mail.sendEmail(member.getEmail(), "회원가입을 축하합니다.", re.getBody());
		
	}
	
	public void insertMember(Member member) {
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		repo.save(member);
	}
	
	public void updateMember(Member member) {
		member.setPassword(passwordEncoder.encode(member.getPassword()));
	}

	@Override
	public void updateMemberToLeave(String userId) {
		Member member  = repo.findById(userId).get();
		member.setIsLeave(1);
	}
}
