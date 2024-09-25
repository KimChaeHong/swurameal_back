package com.company.swurameal.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.swurameal.dto.NoticeDto;
import com.company.swurameal.dto.Pager;
import com.company.swurameal.dto.UserDto;
import com.company.swurameal.sercurity.CustomUserDetails;
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
	
	// 공지사항 전체 목록을 페이징 처리해서 보여주는 메서드
	@RequestMapping("/notice")
	public String adminNotice(
		@RequestParam(defaultValue="1") int pageNo, 
		HttpSession session,
		Model model
		) {
			int totalRows = noticeService.getTotalRows();
			Pager pager = new Pager(5, 5, totalRows, pageNo);
			session.setAttribute("pager", pager);
			List<NoticeDto> list = noticeService.getNotice(pager);
			model.addAttribute("list", list);
			log.info("관리자 공지사항");
			return "admin/notice";
	}
	
	@RequestMapping("/answer")
	public String adminAnswer() {
		log.info("1:1 문의답변");
		return "admin/answer";
	}
}
