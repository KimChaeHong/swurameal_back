package com.company.swurameal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.swurameal.dto.GoodsDto;
import com.company.swurameal.dto.GoodsRegForm;
import com.company.swurameal.service.GoodsService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/mgmt")
@Slf4j
public class MgmtController {
	@Autowired
	private GoodsService goodsService;
	
	//등록 된 상품 보기
	@RequestMapping("/registedList")
	public String adminGm(Model model) {
		log.info("상품관리");
		List<GoodsDto> goodsList = goodsService.getAllGoods();
	    model.addAttribute("goodsList", goodsList);
	        
		return "management/gMgmt";
	}
	
	//상품 새로 등록하기
	@GetMapping("/gReg")
	public String gReg() {

		return "management/gReg";
	}
	
	@PostMapping("/registGoods")
	public String registGoods(GoodsRegForm form) {
		log.info(form.toString());
		GoodsDto goods = new GoodsDto();
		goods.setGoodsName(form.getGoodsName());
		goods.setCategory(form.getCategory());
		goods.setSubcategory(form.getSubcategory());
		goods.setPrice(form.getPrice());
		goods.setGoodsComment(form.getGoodsComment());
		goods.setGoodsOrigin(form.getGoodsOrigin());
		goods.setDeliveryInfo(form.getDeliveryInfo());
		goods.setSeller(form.getSeller());
		goods.setSaleUnit(form.getSaleUnit());
		goods.setWeight(form.getWeight());
		goods.setStock(form.getStock());
		goods.setStatus(form.getStatus());
		
		goodsService.registGoods(goods);
		return "management/gReg";
	}
	
	
}
