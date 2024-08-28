package com.company.swurameal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/goods")
@Slf4j
public class GoodsCotroller {
	
	@RequestMapping("/detail")
	public String detail() {
		log.info("제품 상세");
		return "goods/detail";
	}
	
}
