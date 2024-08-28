package com.company.swurameal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/category")
@Slf4j
public class CategoryController {
	@RequestMapping("/all")
	public String allGoods() {
		log.info("전체상품");
		return "category/all";
	}
	
	@RequestMapping("/snacks")
	public String snacks() {
		log.info("분식");
		return "category/snacks";
	}
	
	@RequestMapping("/snacks/tbk")
	public String snacksTbk() {
		log.info("떡볶이");
		return "category/tbk";
	}
	
	@RequestMapping("/snacks/fry")
	public String snacksFry() {
		log.info("튀김");
		return "category/fry";
	}
	
	@RequestMapping("/snacks/frozen")
	public String snacksFrozen() {
		log.info("냉동");
		return "category/frozen";
	}
	
	@RequestMapping("/western")
	public String western() {
		log.info("양식");
		return "category/western";
	}
	
	@RequestMapping("/western/pasta")
	public String westernPasta() {
		log.info("파스타");
		return "category/pasta";
	}
	
	@RequestMapping("/western/steak")
	public String westernStake() {
		log.info("스테이크");
		return "category/steak";
	}
	
	@RequestMapping("/korean")
	public String korean() {
		log.info("한식");
		return "category/korean";
	}
	
	@RequestMapping("/korean/stew")
	public String koreanStew() {
		log.info("전골/찌개");
		return "category/stew";
	}
	
	@RequestMapping("/korean/poaching")
	public String koreanPoaching() {
		log.info("찜/조림");
		return "category/poaching";
	}
	
	@RequestMapping("/korean/roast")
	public String koreanRoast() {
		log.info("볶음/구이");
		return "category/roast";
	}	
	
	@RequestMapping("/trad-drink")
	public String tradDrink() {
		log.info("전통주");
		return "category/tradDrink";
	}
	
	@RequestMapping("/trad-drink/takju")
	public String tradTakju() {
		log.info("탁주");
		return "category/takju";
	}
	
	@RequestMapping("/trad-drink/distilled")
	public String tradDistilled() {
		log.info("증류주");
		return "category/distilled";
	}
	
	@RequestMapping("/trad-drink/fruit")
	public String tradFruit() {
		log.info("과실주");
		return "category/fruit";
	}
	
}
