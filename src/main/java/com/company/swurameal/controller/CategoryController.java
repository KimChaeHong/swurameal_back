package com.company.swurameal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.swurameal.dto.GoodsDto;
import com.company.swurameal.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/category")
@Slf4j
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	//카테고리목록 나열
	/*@GetMapping("/catogiryList")
	public String categoryList(int goodsId) {
		
		GoodsDto category = categoryService.selectCategory(goodsId);
		
		return category;
	}*/
	
	@GetMapping("/all")
	public String allGoods() {
		log.info("전체상품");
		return "category/all";
	}
	
	@GetMapping("/snacks")
	public String snacks() {
		log.info("분식");
		return "category/snacks";
	}
	
	@GetMapping("/snacks/tbk")
	public String snacksTbk() {
		log.info("떡볶이");
		return "category/tbk";
	}
	
	@GetMapping("/snacks/fry")
	public String snacksFry() {
		log.info("튀김");
		return "category/fry";
	}
	
	@GetMapping("/snacks/frozen")
	public String snacksFrozen() {
		log.info("냉동");
		return "category/frozen";
	}
	
	@GetMapping("/western")
	public String western() {
		log.info("양식");
		return "category/western";
	}
	
	@GetMapping("/western/pasta")
	public String westernPasta() {
		log.info("파스타");
		return "category/pasta";
	}
	
	@GetMapping("/western/steak")
	public String westernStake() {
		log.info("스테이크");
		return "category/steak";
	}
	
	/*@GetMapping("/korean")
	public String korean(String korean, Model model) {
		List<GoodsDto> list = categoryService.getGoods(korean);
		model.addAttribute("list", list);
		log.info("한식");
		return "category/korean";
	}*/
	
	@GetMapping("/korean/stew")
	public String koreanStew() {
		log.info("전골/찌개");
		return "category/stew";
	}
	
	@RequestMapping("/korean/poaching")
	public String koreanPoaching() {
		log.info("찜/조림");
		return "category/poaching";
	}
	
	@GetMapping("/korean/roast")
	public String koreanRoast() {
		log.info("볶음/구이");
		return "category/roast";
	}	
	
	@GetMapping("/tradDrink")
	public String tradDrink() {
		log.info("전통주");
		return "category/tradDrink";
	}
	
	@GetMapping("/tradDrink/takju")
	public String tradTakju() {
		log.info("탁주");
		return "category/takju";
	}
	
	@GetMapping("/tradDrink/distilled")
	public String tradDistilled() {
		log.info("증류주");
		return "category/distilled";
	}
	
	@GetMapping("/tradDrink/fruit")
	public String tradFruit() {
		log.info("과실주");
		return "category/fruit";
	}
	
}
