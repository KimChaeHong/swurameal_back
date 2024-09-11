package com.company.swurameal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	//상품 하나 가져오기
	/*@GetMapping("/goods")
	public String goods(@RequestParam("goodsId")int goodsId, Model model) {
		GoodsDto goods = goodsService.getGoods(goodsId);
		log.info(goods.getCategory());
		model.addAttribute("goods", goods);
		return "common/main";
	}*/
	

	

	
}
