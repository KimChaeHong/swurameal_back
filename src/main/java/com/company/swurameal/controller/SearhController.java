package com.company.swurameal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SearhController {
	@GetMapping("/search")
	public String search(String sword) {
		log.info("검색어: "+sword);
		return "search/search";
	}
	
}
