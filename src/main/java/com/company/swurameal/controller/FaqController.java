package com.company.swurameal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.swurameal.dto.FaqDto;
import com.company.swurameal.service.FaqService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/support")
public class FaqController {
	@Autowired
	private FaqService faqService;
	
	
	@GetMapping("/faq")
	public String supportFaq(int faqId, Model model) {
		List<FaqDto> list = faqService.getFaq(faqId);
		model.addAttribute("list", list);
		log.info("자주하는 질문");
		
		return "support/faq";
	}

}
