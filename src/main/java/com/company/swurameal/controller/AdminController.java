package com.company.swurameal.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.swurameal.dto.NoticeDto;
import com.company.swurameal.dto.NoticeWriteDto;
import com.company.swurameal.dto.Pager;
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
	public String adminNotice(
		@RequestParam(defaultValue="1") int pageNo, 
		HttpSession session,
		Model model
		) {
			log.info("관리자 공지사항");
			int totalRows = noticeService.getTotalRows();
			Pager pager = new Pager(5, 5, totalRows, pageNo);
			session.setAttribute("pager", pager);
			List<NoticeDto> list = noticeService.getNotice(pager);
			model.addAttribute("list", list);
			return "admin/notice";
	}
	
	@RequestMapping("/noticeWrite")
	public String adminNoticeWrite(Model model) {
		log.info("관리자 공지사항");
		return "admin/noticeWrite";
	}
	
	@PostMapping("/noticeInsert")
	public String adminNoticeInsert(@ModelAttribute NoticeWriteDto noticeWriteDto) {
		NoticeDto noticeDto = new NoticeDto();
		Date date = new Date();
		noticeDto.setUserId("swura4789");
		noticeDto.setNoticeTitle(noticeWriteDto.getNoticeTitle());
		noticeDto.setNoticeContent(noticeWriteDto.getNoticeContent());
		noticeDto.setNoticeRegisterDate(date);
		noticeService.insertNotice(noticeDto);
		return "redirect:/admin/notice";
	}
	
	@GetMapping("/noticeDetail")
	public String adminNoticeDetail(@RequestParam int noticeId, Model model) {
		NoticeDto noticeDto = noticeService.getNoticeById(noticeId);
		model.addAttribute("notice", noticeDto);
		return "admin/noticeDetail";
	}
	
	@GetMapping("/noticeDelete")
	public String adminNoticeDelete(int noticeId) {
		noticeService.deleteNotice(noticeId);
		return "redirect:/admin/notice";
	}
	
	@GetMapping("/noticeUpdateForm")
	public String adminNoticeUpdateForm(@RequestParam int noticeId, Model model) {
		NoticeDto noticeDto = noticeService.getNoticeById(noticeId);
		model.addAttribute("notice", noticeDto);
		return "admin/noticeUpdateForm";
	}
	
	@PostMapping("/noticeUpdate")
	public String adminNoticeUpdate(@ModelAttribute NoticeWriteDto noticeWriteDto) {
		NoticeDto noticeDto = new NoticeDto();
		noticeDto.setNoticeId(noticeWriteDto.getNoticeId());
		noticeDto.setNoticeTitle(noticeWriteDto.getNoticeTitle());
		noticeDto.setNoticeContent(noticeWriteDto.getNoticeContent());
		log.info(""+ noticeDto);
		log.info(""+ noticeWriteDto);
		
		noticeService.updateNotice(noticeDto);
		return "redirect:/admin/notice";
	}
	
	@RequestMapping("/answer")
	public String adminAnswer() {
		log.info("1:1 문의답변");
		return "admin/answer";
	}
}
