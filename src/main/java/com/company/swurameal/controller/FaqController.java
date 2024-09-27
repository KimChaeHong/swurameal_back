package com.company.swurameal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.swurameal.dto.FaqDto;
import com.company.swurameal.dto.UserDto;
import com.company.swurameal.sercurity.CustomUserDetails;
import com.company.swurameal.service.FaqService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/admin")
public class FaqController {
	@Autowired
	private FaqService faqService;

	@GetMapping("/faq")
	public String adminFaq(String faq, Model model) {
		List<FaqDto> list = faqService.getFaq(faq);
		model.addAttribute("list", list);
		log.info("자주하는 질문");

		return "admin/faq";
	}

	// FAQ 작성페이지로 넘어가는 메서드
	@RequestMapping("/faqWrite")
	public String adminFaqWrite(Model model) {		
		log.info("관리자 자주하는 질문");
		return "admin/faqWrite";
	}	

	//FAQ 작성하는 메서드 
	@PostMapping("/faqInsert")
	public String adminFaqInsert(@ModelAttribute FaqDto faqDto, Authentication authentication) {
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		UserDto user = userDetails.getUserDto();
		String userId = user.getUserId();
		
		
		log.info(userId);
		
		FaqDto faqInsert = new FaqDto();
		log.info("잘들어오니"+faqInsert);
		
		faqInsert.setUserId(userId);
		faqInsert.setFaqTitle(faqDto.getFaqTitle());
		faqInsert.setFaqContent(faqDto.getFaqContent());
		faqService.insertFaq(faqInsert);
		log.info("관리자 자주하는 질문");
		return "redirect:/admin/faq";
	}
	
		//FAQ 삭제하는 메서드
		@GetMapping("/faqDelete")
		public String adminFaqDelete(int faqId) {
			faqService.deleteFaq(faqId);
			log.info("관리자 자주하는 질문");
			return "redirect:/admin/faq";
		}
	
		//FAQ 수정 페이지로 넘어가는 메서드
		@GetMapping("/faqUpdateForm")
		public String adminFaqUpdateForm(@RequestParam int faqId, Model model) {
			FaqDto faqDto = faqService.getFaqById(faqId);
			model.addAttribute("faq", faqDto);
			log.info("관리자 자주하는 질문" + faqDto.getFaqTitle() + faqDto.toString());
			return "admin/faqUpdateForm";
		}
		
		
		
		//FAQ 수정하는 메서드
		@PostMapping("/faqUpdate")
		public String adminFaqUpdate(@ModelAttribute FaqDto faqDto) {
			FaqDto updateFaq = new FaqDto();
			updateFaq.setFaqId(faqDto.getFaqId());
			updateFaq.setFaqTitle(faqDto.getFaqTitle());
			updateFaq.setFaqContent(faqDto.getFaqContent());
			faqService.updateFaq(updateFaq);
			log.info("관리자 자주하는 질문");
			return "redirect:/admin/faq";
		}
}
