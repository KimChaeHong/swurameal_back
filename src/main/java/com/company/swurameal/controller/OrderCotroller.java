package com.company.swurameal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class OrderCotroller {
	
	@RequestMapping("/order")
	public String order() {
		log.info("주문");
		return "order/order";
	}
	
}
