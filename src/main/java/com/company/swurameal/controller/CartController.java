package com.company.swurameal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.swurameal.dto.CartDto;
import com.company.swurameal.dto.UserDto;
import com.company.swurameal.sercurity.CustomUserDetails;
import com.company.swurameal.service.CartService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CartController {
	@Autowired
	private CartService cartService;
	
	// 장바구니 페이지로 이동
	@RequestMapping("/cart")
	public String veiwCart(Model model, Authentication authentication)  {
		
		//사용자의 모든 정보를 얻고 싶을 경우
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		UserDto user = userDetails.getUserDto();
		String userId = user.getUserId(); // 로그인된 사용자의 userId
		
		// 장바구니에 담긴 모든 상품 조회
        List<CartDto> cartGoods = cartService.getCartByUserID(userId);
        
        log.info(cartGoods.toString());
		
		// 모델에 사용자와 장바구니 정보 추가
        model.addAttribute("user", user);
        model.addAttribute("cartGoods", cartGoods);
		return "/cart";
	}
	
	
	
	
	
	
	
	
	
	
	
   


}
