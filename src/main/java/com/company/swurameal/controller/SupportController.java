package com.company.swurameal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/support")
@Slf4j
public class SupportController {
	@RequestMapping("/notice")
	public String supportNotice() {
		log.info("공지사항");
		return "support/notice";
	}
	
	@RequestMapping("/faq")
	public String supportFaq() {
		log.info("자주하는 질문");
		return "support/faq";
	}
	
	@RequestMapping("/qna")
	public String supportAnswer() {
		log.info("1:1 문의");
		return "support/qna";
	}
		
		
}
