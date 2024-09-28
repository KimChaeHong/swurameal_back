package com.company.swurameal.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.company.swurameal.dto.Pager;
import com.company.swurameal.dto.QuestionDto;
import com.company.swurameal.dto.QuestionWriteForm;
import com.company.swurameal.service.QnaService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/qna")
@Slf4j
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	//전체 회원의 QnA목록을 볼 수 있는 메서드
	@GetMapping("/qnaList")
	public String adminQm(Model model, @RequestParam(defaultValue="1") int pageNo, HttpSession session) {
		
		int totalRows = qnaService.getTotalRows();
		Pager pager = new Pager(5, 5,totalRows, pageNo);
		session.setAttribute("pager", pager);
		
		List<QuestionDto> list = qnaService.getQuestionList(pager);
		model.addAttribute("list", list);
		
		return "qna/qnaList";
	}
	
	//회원이 질문 쓰기
	@PostMapping("/questionWrite")
	public String writeQuestion(QuestionWriteForm form, HttpSession session) {
		QuestionDto question = new QuestionDto();
		question.setQuestionTitle(form.getQuestionTitle());
		question.setQuestionContent(form.getQuestionContent());
		
		qnaService.writeQuestion(question);
		return "redirect:/qna/qnaList";
	}
	
	
	
	
	
	

}
