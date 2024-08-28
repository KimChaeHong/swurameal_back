package com.company.swurameal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {
	
	@RequestMapping("/goodsManagement")
	public String adminGm() {
		log.info("상품관리");
		return "admin/goodsManagement";
	}
	
	@RequestMapping("/faq")
	public String adminFaq() {
		log.info("자주하는 질문");
		return "admin/faq";
	}
	
	@RequestMapping("/notice")
	public String adimNotice() {
		log.info("관리자 공지사항");
		return "admin/notice";
	}
	
	@RequestMapping("/answer")
	public String adminAnswer() {
		log.info("1:1 문의답변");
		return "admin/answer";
	}
}
