package com.company.swurameal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.swurameal.dto.NoticeDto;
import com.company.swurameal.service.NoticeService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {
	
	@Autowired
	private NoticeService noticeService;
	
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
	public String adminNotice(Model model) {
		log.info("관리자 공지사항");
		List<NoticeDto> list = noticeService.getNotice();
		model.addAttribute("list", list);
		return "admin/notice";
	}
	
	@RequestMapping("/noticeWrite")
	public String adminNoticeWrite(Model model) {
		log.info("관리자 공지사항");
		return "admin/noticeWrite";
	}
	
	@RequestMapping("/noticeEdit")
	public void adminNoticeAdd(
			@RequestParam String action,
			@RequestParam String title,
			@RequestParam String content
			) {
		
	}
	
	@RequestMapping("/answer")
	public String adminAnswer() {
		log.info("1:1 문의답변");
		return "admin/answer";
	}
}
