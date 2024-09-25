package com.company.swurameal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.swurameal.service.NoticeService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {
	

	@Autowired
	private NoticeService noticeService;

	
	@RequestMapping("/faq")
	public String adminFaq() {
		log.info("자주하는 질문");
		return "admin/faq";
	}
	
	@RequestMapping("/answer")
	public String adminAnswer() {
		log.info("1:1 문의답변");
		return "admin/answer";
	}
}
