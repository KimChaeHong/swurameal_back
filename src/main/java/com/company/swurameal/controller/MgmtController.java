package com.company.swurameal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/mgmt")
@Slf4j
public class MgmtController {
	
	@RequestMapping("/gMgmt")
	public String adminGm() {
		log.info("상품관리");
		return "management/gMgmt";
	}
	
	
	@GetMapping("/gReg")
	public String gReg() {
		log.info("상품 등록");
		return "management/gReg";
	}
}
