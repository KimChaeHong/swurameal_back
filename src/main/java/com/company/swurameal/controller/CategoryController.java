package com.company.swurameal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.swurameal.dto.GoodsDto;
import com.company.swurameal.service.GoodsService;


import lombok.extern.slf4j.Slf4j;

@Controller 
@RequestMapping("/category")
@Slf4j
public class CategoryController {

	@Autowired
	private GoodsService goodsService; // GoodsService를 사용하여 상품 목록을 가져옴

	//모든 상품 가져오기
	@GetMapping("/all")
	public String allGoods(Model model) {
		// GoodsService를 통해 전체 상품 목록 가져오기
        List<GoodsDto> goodsList = goodsService.getAllGoods();
        model.addAttribute("goodsList", goodsList);
        
        return "category/all";  // category/all.jsp로 이동
	}
	
	@GetMapping("/category")
	public String category(Model model) {
		log.info("카테고리");
		List<GoodsDto> goodsList = goodsService.getGoodsCategory("카테고리");
		model.addAttribute("goodsList", goodsList);
		return "category";
	}
	
	
	
	@GetMapping("/snacks")
	public String snacks(Model model) {
		log.info("분식");
		List<GoodsDto> goodsList = goodsService.getGoodsCategory("분식");
		model.addAttribute("goodsList", goodsList);
		return "category/snacks";
	}
	
	@GetMapping("/snacks/tbk")
	public String snacksTbk(Model model) {
		log.info("떡볶이");
		List<GoodsDto> goodsList = goodsService.getGoodsSubCategory("떡볶이");
		model.addAttribute("goodsList", goodsList);
		return "category/tbk";
	}
	
	@GetMapping("/snacks/fry")
	public String snacksFry(Model model) {
		log.info("튀김");
		List<GoodsDto> goodsList = goodsService.getGoodsSubCategory("튀김");
		model.addAttribute("goodsList", goodsList);
		return "category/fry";
	}
	
	@GetMapping("/snacks/frozen")
	public String snacksFrozen(Model model) {
		log.info("냉동");
		List<GoodsDto> goodsList = goodsService.getGoodsSubCategory("냉동");
		model.addAttribute("goodsList", goodsList);
		return "category/frozen";
	}
	
	@GetMapping("/western")
	public String western(Model model) {
		log.info("양식");
		List<GoodsDto> goodsList = goodsService.getGoodsCategory("양식");
		model.addAttribute("goodsList", goodsList);
		return "category/western";
	}
	
	@GetMapping("/western/pasta")
	public String westernPasta(Model model) {
		log.info("파스타");
		List<GoodsDto> goodsList = goodsService.getGoodsSubCategory("파스타");
		model.addAttribute("goodsList", goodsList);
		return "category/pasta";
	}
	
	@GetMapping("/western/steak")
	public String westernStake(Model model) {
		log.info("스테이크");
		List<GoodsDto> goodsList = goodsService.getGoodsSubCategory("스테이크");
		model.addAttribute("goodsList", goodsList);
		return "category/steak";
	}
	@GetMapping("/korean")
	public String korean(Model model) {
		log.info("한식");
		List<GoodsDto> goodsList = goodsService.getGoodsCategory("한식");
		model.addAttribute("goodsList", goodsList);
		return "category/korean";
	}
	
	
	@GetMapping("/korean/stew")
	public String koreanStew(Model model) {
		log.info("전골/찌개");
		List<GoodsDto> goodsList = goodsService.getGoodsSubCategory("전골/찌개");
		model.addAttribute("goodsList", goodsList);
		return "category/stew";
	}
	
	@RequestMapping("/korean/poaching")
	public String koreanPoaching(Model model) {
		log.info("찜/조림");
		List<GoodsDto> goodsList = goodsService.getGoodsSubCategory("찜/조림");
		model.addAttribute("goodsList", goodsList);
		return "category/poaching";
	}
	
	@GetMapping("/korean/roast")
	public String koreanRoast(Model model) {
		log.info("볶음/구이");
		List<GoodsDto> goodsList = goodsService.getGoodsSubCategory("볶음/구이");
		model.addAttribute("goodsList", goodsList);
		return "category/roast";
	}	
	
	//전통주 가져오기
	@GetMapping("/tradDrink")
	public String tradDrink(Model model) {
		log.info("전통주");
		List<GoodsDto> goodsList = goodsService.getGoodsCategory("전통주");
        model.addAttribute("goodsList", goodsList);
		return "category/tradDrink";
	}
	
	@GetMapping("/tradDrink/takju")
	public String tradTakju(Model model) {
		log.info("탁주");
		List<GoodsDto> goodsList = goodsService.getGoodsSubCategory("탁주");
        model.addAttribute("goodsList", goodsList);
		return "category/takju";
	}
	
	@GetMapping("/tradDrink/distilled")
	public String tradDistilled(Model model) {
		log.info("증류주");
		List<GoodsDto> goodsList = goodsService.getGoodsSubCategory("증류주");
        model.addAttribute("goodsList", goodsList);
		return "category/distilled";
	}
	
	@GetMapping("/tradDrink/fruit")
	public String tradFruit(Model model) {
		log.info("과실주");
		List<GoodsDto> goodsList = goodsService.getGoodsSubCategory("과실주");
        model.addAttribute("goodsList", goodsList);
		return "category/fruit";
	}
	
}
