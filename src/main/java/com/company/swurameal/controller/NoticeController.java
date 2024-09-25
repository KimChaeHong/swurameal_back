package com.company.swurameal.controller;

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
import com.company.swurameal.dto.UserDto;
import com.company.swurameal.sercurity.CustomUserDetails;
import com.company.swurameal.service.NoticeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("admin/notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	// 공지사항 하나의 내용을 보여주는 메서드
	@GetMapping("/noticeDetail")
	public String adminNoticeDetail(@RequestParam int noticeId, Model model) {
		NoticeDto noticeDto = noticeService.getNoticeById(noticeId);
		model.addAttribute("notice", noticeDto);
		log.info("관리자 공지사항");
		return "admin/noticeDetail";
	}
	
	// 공지사항 작성페이지로 넘어가는 메서드
	@RequestMapping("/noticeWrite")
	public String adminNoticeWrite(Model model) {
		log.info("관리자 공지사항");
		return "admin/noticeWrite";
	}
	
	// 공지사항을 작성하는 메서드 
	@PostMapping("/noticeInsert")
	public String adminNoticeInsert(@ModelAttribute NoticeDto noticeDto, Authentication authentication) {
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		UserDto user = userDetails.getUserDto();
		String userId = user.getUserId();
		
		NoticeDto noticeInsert = new NoticeDto();
		noticeInsert.setUserId(userId);
		noticeInsert.setNoticeTitle(noticeDto.getNoticeTitle());
		noticeInsert.setNoticeContent(noticeDto.getNoticeContent());
		noticeService.insertNotice(noticeInsert);
		log.info("관리자 공지사항");
		return "redirect:/admin/notice";
	}
	
	// 공지사항을 삭제하는 메서드
	@GetMapping("/noticeDelete")
	public String adminNoticeDelete(int noticeId) {
		noticeService.deleteNotice(noticeId);
		log.info("관리자 공지사항");
		return "redirect:/admin/notice";
	}
	
	// 공지사항을 수정 페이지로 넘어가는 메서드
	@GetMapping("/noticeUpdateForm")
	public String adminNoticeUpdateForm(@RequestParam int noticeId, Model model) {
		NoticeDto noticeDto = noticeService.getNoticeById(noticeId);
		model.addAttribute("notice", noticeDto);
		log.info("관리자 공지사항");
		return "admin/noticeUpdateForm";
	}
	
	// 공지사항을 수정하는 메서드
	@PostMapping("/noticeUpdate")
	public String adminNoticeUpdate(@ModelAttribute NoticeDto noticeDto) {
		NoticeDto updateNotice = new NoticeDto();
		updateNotice.setNoticeId(noticeDto.getNoticeId());
		updateNotice.setNoticeTitle(noticeDto.getNoticeTitle());
		updateNotice.setNoticeContent(noticeDto.getNoticeContent());
		noticeService.updateNotice(updateNotice);
		log.info("관리자 공지사항");
		return "redirect:/admin/notice";
	}
	
}
