package com.kh.spring.common.mail.handler;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MailHandler {

	@PostMapping("mail")
	public String writeMailTemplate(@RequestParam Map<String,String> template) {
		return "mail-template/" + template.get("mail-template");
	}
	
	
}
