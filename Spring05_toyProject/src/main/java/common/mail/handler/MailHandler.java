package common.mail.handler;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MailHandler {
	
	@PostMapping("mail")
	private String writeMail(@RequestParam Map<String,String> member, Model model) {
		System.out.println("Handler : " + member);
		model.addAllAttributes(member);
		return "mail-template/" + member.get("mail-template");
	}
}
