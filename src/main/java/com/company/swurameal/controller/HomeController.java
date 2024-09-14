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
@Slf4j
public class HomeController {
	@Autowired
	private GoodsService goodsService; // GoodsService를 사용하여 상품 목록을 가져옴
	
	@RequestMapping("")
	public String index(Model model) {
		log.info("홈");
		
		// GoodsService를 통해 전체 상품 목록 가져오기
	    List<GoodsDto> goodsList = goodsService.getAllGoods();
	    /*for(GoodsDto goods : goodsList) {
	    	log.info(goods.toString());
	    }*/
	    model.addAttribute("goodsList", goodsList);
		
		return "home";
	}
	
	

}
