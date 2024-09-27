package com.company.swurameal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/qna")
@Slf4j
public class QnaController {
	
	//관리자가 전체 회원의 QnA목록을 볼 수 있는 메서드
	@GetMapping("/qnaList")
	public String adminQm() {
		
		return "qna/qnaList";
	}

}
