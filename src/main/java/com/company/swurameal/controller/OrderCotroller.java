package com.company.swurameal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.swurameal.dto.CartDto;
import com.company.swurameal.dto.UserDto;
import com.company.swurameal.sercurity.CustomUserDetails;
import com.company.swurameal.service.CartService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/order")
public class OrderCotroller {
	
	@Autowired
	private CartService cartService;
	
	@Secured("ROLE_USER")
	@RequestMapping("/order")
	public String order(
		Model model,
		Authentication authentication
			) {
			CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
			UserDto user = userDetails.getUserDto();
			String userId = user.getUserId();
			
			List<CartDto> cartList = cartService.getGoods(userId);
			
			log.info("주문");
			return "order/order";
	}
	
}
