package com.company.swurameal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.swurameal.dto.GoodsDto;
import com.company.swurameal.service.GoodsService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("/detail")
	public String detail() {
		log.info("제품 상세");
		return "goods/detail";
	}
	
	@GetMapping("/goods")
	public String goods(int goodsId, Model model) {
		GoodsDto goods = goodsService.getGoods(goodsId);
		model.addAttribute("goods", goods);
		return "common/main";
	}

	
}
