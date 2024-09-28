package com.company.swurameal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.swurameal.dto.CartDto;
import com.company.swurameal.sercurity.CustomUserDetails;
import com.company.swurameal.service.CartService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService cartService;

	//카트 리스트 조회
	@Secured("ROLE_USER")
	@GetMapping("/itemList")
	public String cartItemList(Authentication authentication, Model model) {
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		String userInfo = userDetails.getUsername(); // 사용자 ID 가져오기
		model.addAttribute("user", userDetails.getUserDto());

		List<CartDto> cartList = cartService.getGoods(userInfo); // 항목조회
		model.addAttribute("goodsList", cartList);

		// 장바구니가 비어있을때
		if (cartList.isEmpty()) {
			model.addAttribute("message", "장바구니가 비어있습니다.");
		}

		return "cart/itemList";

	}

	//카트 데이터 추가
	@Secured("ROLE_USER")
	@GetMapping("/itemAdd")
	public ResponseEntity<Void> addCartItem(@RequestParam Integer goodsId,
			@RequestParam(defaultValue = "1") int quantity, 
			Authentication authentication) {

		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		String userInfo = userDetails.getUsername(); // 사용자 ID 가져오기

		//goodsId가 제공되면 장바구니에 항목 추가
		CartDto cartItem = new CartDto();
		cartItem.setGoodsId(goodsId);
		cartItem.setQuantity(quantity);
		cartItem.setUserId(userInfo);
		cartService.addGoodsToCart(cartItem);

		return ResponseEntity.ok().build();

	}

	//카트 아이템 삭제하기
	@Secured("ROLE_USER")
	@GetMapping("/itemDelete")
	public String deleteCartItem(@RequestParam int goodsId, Authentication authentication) {

		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		String userInfo = userDetails.getUsername(); // 사용자 ID 가져오기

		//goodsId가 null인 경우
		if (userInfo == null) {
			throw new IllegalArgumentException("User ID cannot be null");
		}

		//삭제할 아이템 생성
		CartDto cartItem = new CartDto();
		cartItem.setUserId(userInfo);
		cartItem.setGoodsId(goodsId);
		cartItem.setQuantity(1);

		cartService.deleteGoodsFromCart(cartItem, userInfo);
		return "redirect:/cart/itemList";
	}
	
	//카트 전체 아이템 삭제하기
	@Secured("ROLE_USER")
	@GetMapping("/itemAllDelete")
	public String itemAllDelete(Authentication authentication) {
		String userId = authentication.getName();
		cartService.deleteAllGoodsFromCart(userId);
		
		return "redirect:/cart/itemList";
	}
	
	//DB에 데이터 넣기
	@Secured("ROLE_USER")
	@PostMapping("/update")
	@ResponseBody
	public String updateCartItemCount(@RequestParam int goodsId, @RequestParam int quantity, Authentication authentication) {
		
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		String userInfo = userDetails.getUsername(); // 사용자 ID 가져오기
		
		//업데이트할 아이템 생성
		CartDto cartItem = new CartDto();
		cartItem.setUserId(userInfo);
		cartItem.setGoodsId(goodsId);
		cartItem.setQuantity(quantity);

		cartService.updateGoodsFromCart(cartItem);
		return "ok";
	}	
	
	//수량 업데이트
	@Secured("ROLE_USER")
	@GetMapping("/itemCount")
	@ResponseBody //응답 본문으로 직접 데이터를 반환
	public String itemCount(Authentication authentication, Model model) {	
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		String userInfo = userDetails.getUsername(); //사용자 ID 가져오기
		
		int cartCount = cartService.countItemsInCart(userInfo); //카트 수량 가져오기
		model.addAttribute("cartCount", cartCount);

		List<CartDto> cartList = cartService.getGoods(userInfo); // 항목조회
		model.addAttribute("goodsList", cartList);
		
		if (cartList.isEmpty()) {
			model.addAttribute("message", "장바구니가 비었습니다.");
		}
		return "cart/itemList";
	}
}
