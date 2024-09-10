package com.company.swurameal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.swurameal.dto.GoodsDto;
import com.company.swurameal.service.GoodsService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/goods")
@Slf4j
public class GoodsCotroller {
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("/detail")
	public String detail() {
		log.info("제품 상세");
		return "goods/detail";
	}
	
	//상품 목록
	public String goodsList(Model model) {
		
		
		return "/";
	}
	
	
}
