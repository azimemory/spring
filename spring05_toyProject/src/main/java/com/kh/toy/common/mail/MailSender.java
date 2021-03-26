package com.kh.toy.common.mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import com.kh.toy.common.code.Code;

@Component
@EnableAsync //해당 클래스에서 Async 어노테이션을 사용할 수 있게 해줌
public class MailSender {
	
	@Autowired
	JavaMailSender mailSender;
	@Async
	public void send(String to, String subject, String htmlTxt) {
		try {
			MimeMessage msg = mailSender.createMimeMessage();
			msg.setFrom(Code.EMAIL.desc);
			msg.setRecipients(Message.RecipientType.TO, to);
			msg.setSubject(subject);
			msg.setContent(htmlTxt,"text/html; charset=UTF-8");
		
			mailSender.send(msg);
		
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
