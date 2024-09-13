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
	
	@GetMapping("/snacks")
	public String snacks(Model model) {
		log.info("분식");
		List<GoodsDto> goodsList = goodsService.getGoodsCategory("분식");
		model.addAttribute("goodsList", goodsList);
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
	public String western(Model model) {
		log.info("양식");
		List<GoodsDto> goodList = goodsService.getGoodsCategory("양식");
		model.addAttribute("goodsList", goodList);
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
	
	@GetMapping("/korean")
	public String korean(Model model) {
		log.info("한식");
		List<GoodsDto> goodsList = goodsService.getGoodsCategory("한식");
		model.addAttribute("goodsList", goodsList);
		return "category/korean";
	}
	
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
	
	//전통주 가져오기
	@GetMapping("/tradDrink")
	public String tradDrink(Model model) {
		log.info("전통주");
		List<GoodsDto> goodsList = goodsService.getGoodsCategory("전통주");
        model.addAttribute("goodsList", goodsList);
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
