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

import com.company.swurameal.dto.FaqDto;
import com.company.swurameal.dto.Pager;
import com.company.swurameal.dto.UserDto;
import com.company.swurameal.sercurity.CustomUserDetails;
import com.company.swurameal.service.FaqService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/faq")
public class FaqController {
	@Autowired
	private FaqService faqService;

	//FAQ 전체 목록을 페이징 처리해서 보여주는 메서드
	@GetMapping("/faqList")
	public String getFaqList(
		@RequestParam(defaultValue="1") int pageNo,
		HttpSession session, 
		Model model
		) {
			int totalRows = faqService.getTotalRows();
			Pager pager = new Pager(5, 5, totalRows, pageNo);
			session.setAttribute("pager", pager);
			List<FaqDto> list = faqService.getFaq(pager);
			model.addAttribute("list", list);
			return "faq/faqList";
	}

	// FAQ 작성페이지로 넘어가는 메서드
	@RequestMapping("/faqRegister")
	public String navToFaqRegister(Model model) {		
		return "faq/faqRegister";
	}	

	//FAQ 작성하는 메서드 
	@PostMapping("/faqWrite")
	public String writeFaq(@ModelAttribute FaqDto faqDto, Authentication authentication) {
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		UserDto user = userDetails.getUserDto();
		String userId = user.getUserId();
		
		FaqDto faqInsert = new FaqDto();	
		faqInsert.setUserId(userId);
		faqInsert.setFaqTitle(faqDto.getFaqTitle());
		faqInsert.setFaqContent(faqDto.getFaqContent());
		faqService.insertFaq(faqInsert);
		return "redirect:/faq/faqList";
	}
	
		//FAQ 삭제하는 메서드
		@GetMapping("/faqDelete")
		public String deleteFaq(int faqId) {
			faqService.deleteFaq(faqId);
			return "redirect:/faq/faqList";
		}
	
		//FAQ 수정 페이지로 넘어가는 메서드
		@GetMapping("/faqUpdateForm")
		public String navToFaqUpdateForm(@RequestParam int faqId, Model model) {
			FaqDto faqDto = faqService.getFaqById(faqId);
			model.addAttribute("faq", faqDto);
			return "faq/faqUpdateForm";
		}
	
		
		//FAQ 수정하는 메서드
		@PostMapping("/faqUpdate")
		public String editFaq(@ModelAttribute FaqDto faqDto) {
			FaqDto updateFaq = new FaqDto();
			updateFaq.setFaqId(faqDto.getFaqId());
			updateFaq.setFaqTitle(faqDto.getFaqTitle());
			updateFaq.setFaqContent(faqDto.getFaqContent());
			faqService.updateFaq(updateFaq);
			return "redirect:/faq/faqList";
		}
}
