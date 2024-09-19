package com.company.swurameal.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.swurameal.dto.NoticeDto;
import com.company.swurameal.dto.Pager;
import com.company.swurameal.service.NoticeService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/support")
@Slf4j
public class SupportController {
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("/notice")
	public String supportNotice(Model model) {
		log.info("공지사항");
		List<NoticeDto> list = noticeService.getNotice();
		model.addAttribute("list", list);
		
//			int pageNo, HttpSession session			
//			int totalRows = noticeService.getTotalRows();
//			Pager pager = new Pager(10, 5, totalRows, pageNo);
//			session.setAttribute("pager", pager);
		
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
