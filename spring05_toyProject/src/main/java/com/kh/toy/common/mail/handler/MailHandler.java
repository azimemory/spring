package com.kh.toy.common.mail.handler;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MailHandler {
	@PostMapping("mail")
	public String writeMail(@RequestParam Map<String,Object> data
							,@RequestHeader Map<String,Object> header
							, Model model) {
		model.addAllAttributes(data);
		return "mail-template/" + data.get("mail-template");
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
