package com.company.swurameal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.swurameal.dto.CartDto;
import com.company.swurameal.sercurity.CustomUserDetails;
import com.company.swurameal.service.CartService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/order")
public class OrderCotroller {
	@Autowired
	private CartService cartService;
	
	//체크된 상품 리스트 조회
	@Secured("ROLE_USER")
	@RequestMapping("/order")
	public String order(@RequestParam List<Integer> goodsId, @RequestParam List<Integer> quantity,
						Authentication authentication, Model model) {
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		String userInfo = userDetails.getUsername(); //사용자 ID 가져오기
		model.addAttribute("user", userDetails.getUserDto());
		
		//필요한 경우 장바구니에서 상품 조회 로직 추가 가능
		List<CartDto> cartList = cartService.getGoods(userInfo);
		model.addAttribute("goodsList", cartList);
		
		//선택한 상품과 수량을 모델에 추가
		model.addAttribute("selectedGoodsId", goodsId);
		model.addAttribute("selectedQuantity", quantity);
		
		log.info("주문");
		return "order/order";
	}
	
	//주문 카트 아이템 추가
	
	//주문 카트 아이템 삭제
	
	//DB에 데이터 넣기
	
	
	//비체크시 상품 리스트 조회
	
	
	
}
