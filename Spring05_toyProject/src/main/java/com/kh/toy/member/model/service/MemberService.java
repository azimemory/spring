package com.kh.toy.member.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.toy.member.model.dao.MemberDao;
import com.kh.toy.member.model.vo.Member;

import common.code.Code;
import common.mail.MailSender;

@Service
public class MemberService {
	
	private final MemberDao memberDao;
	
	@Autowired
	MailSender mail;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	public MemberService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public Member authenticateUser(Member member) {
		Member info = memberDao.selectMemberById(member.getUserId());
		if(passwordEncoder.matches(member.getPassword(), info.getPassword())) {
			return info;
		}
		
		return null;
	}
	
	public Member selectMemberById(String userId){	
		return memberDao.selectMemberById(userId);
	}
	
	public void authenticateEmail(Map<String,String> member) {
		//RestTemplate의 기본 Contents-type은 application/json
		RestTemplate rt = new RestTemplate();
		
		//Contents-type 변경해보기
		//Application/x-www-form-urlencode 형식으로 보낼 때 body 정보는
		//MultiValueMap<String, String>에 담아줘야한다.
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.setAll(member);
		body.add("mail-template","temp_join");
		HttpEntity entity = new HttpEntity(body,header);
		
		ResponseEntity<String> re = rt.postForEntity(Code.DOMAIN+"/mail", entity, String.class);
		
		System.out.println(re.getBody());
		mail.sendEmail(member.get("email"), "회원가입을 축하합니다.", re.getBody());
	}
	
	public void insertMember(Map<String,String> member) {
		member.put("password",passwordEncoder.encode(member.get("password")));
		memberDao.insertMember(member);
	}
	
	public void updateMember(Member member) {
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		memberDao.updateMember(member);
	}
}
