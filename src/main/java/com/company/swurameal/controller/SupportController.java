package com.company.swurameal.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.swurameal.dto.FaqDto;
import com.company.swurameal.dto.NoticeDto;
import com.company.swurameal.dto.Pager;
import com.company.swurameal.dto.QuestionDto;
import com.company.swurameal.service.FaqService;
import com.company.swurameal.service.NoticeService;
import com.company.swurameal.service.QnaService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/support")
@Slf4j
public class SupportController {
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private FaqService faqService;
	
	@Autowired
	private QnaService qnaService;
	
	@RequestMapping("/notice")
	public String supportNotice(
		@RequestParam(defaultValue="1") int pageNo,
		HttpSession session,
		Model model) {
			log.info("공지사항");
			int totalRows = noticeService.getTotalRows();
			Pager pager = new Pager(5, 5, totalRows, pageNo);
			session.setAttribute("pager", pager);
			List<NoticeDto> list = noticeService.getNotice(pager);
			model.addAttribute("list", list);		
			return "support/notice";
	}

	@RequestMapping("/faq")
	public String supportFaq(
		@RequestParam(defaultValue="1") int pageNo,
		String faq, 
		HttpSession session,
		Model model) {		
			int totalRows = faqService.getTotalRows();
			Pager pager = new Pager(5, 5, totalRows, pageNo);
			session.setAttribute("pager", pager);		
			List<FaqDto> list = faqService.getFaq(pager);
			model.addAttribute("list", list);
			log.info("자주하는 질문");
			
			return "support/faq";
	}
	
	//회원의 QnA목록을 볼 수 있는 메서드
	@GetMapping("/qna")
	public String adminQm(Model model, @RequestParam(defaultValue="1") int pageNo, HttpSession session) {
		
		log.info("qna");
		int totalRows = qnaService.getTotalRows();
		Pager pager = new Pager(5, 5,totalRows, pageNo);
		session.setAttribute("pager", pager);
		List<QuestionDto> list = qnaService.getQuestionList(pager);
		model.addAttribute("list", list);
		return "support/qna";
	}
		
		
}
