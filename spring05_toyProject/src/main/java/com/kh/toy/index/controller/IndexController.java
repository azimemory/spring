package com.kh.toy.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	//혹시 context path가 있다면 생략하고 작성
	@GetMapping("index")
	public String index() {
		return "index/index";
	}
}
