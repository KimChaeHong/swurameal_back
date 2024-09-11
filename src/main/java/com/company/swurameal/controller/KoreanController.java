package com.company.swurameal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.swurameal.dto.GoodsDto;
import com.company.swurameal.service.KoreanService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/category")
public class KoreanController {
	@Autowired
	private KoreanService koreanService;
	
	
	@GetMapping("/korean")
	public String korean(String korean, Model model) {
		List<GoodsDto> list = koreanService.getGoods(korean);
		model.addAttribute("list", list);
		log.info("한식");
		return "category/korean";
	}
}
