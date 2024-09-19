package com.company.swurameal.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.swurameal.dto.CartDto;
import com.company.swurameal.dto.CartItem;
import com.company.swurameal.dto.GoodsDto;
import com.company.swurameal.service.CartService;
import com.company.swurameal.service.GoodsService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private CartService cartService;

	
	@GetMapping("/authorityCheck")
	public String authorityCheck(HttpSession session, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication !=null && authentication.isAuthenticated()) {
			model.addAttribute("message", "로그인이 확인되었습니다.");
			return "redirect:/cart";
		} else {
			model.addAttribute("message", "로그인이 필요합니다.");
			return "user/login";
		}
	}
	
	@GetMapping
	public String cart(HttpSession session, Model model) {
		log.info("장바구니");
		String userId = (String) session.getAttribute("userId");
		List<CartDto> goodsList = cartService.selectGoods(userId);
		session.setAttribute("goodsList", goodsList);
		model.addAttribute("goodsList", goodsList);
		return "cart/cart";
	}
	
	@GetMapping("/cart")
	public String cart(Model model) {
		List<CartDto> cart = new ArrayList<>();
		for(int i=1; i<=5; i++) {
			CartDto item = new CartDto();
			item.setUserId("p" + i);
			cart.add(item);
		}
		model.addAttribute("cart", cart);
		return "cart/cart";
	}
	
	
	@GetMapping("/cartAdd")
	public String cartAdd(int goodsId, HttpSession session) {
		CartItem cart = (CartItem) session.getAttribute("cart");
		if(cart == null) {
			cart = new CartItem();
			session.setAttribute("cart", cart);
		}
		GoodsDto item = goodsService.getGoods(goodsId);
		CartDto cartItem = new CartDto();
		cart.addItem(cartItem);
		session.setAttribute("message", "장바구니에 담았습니다.");
		return "redirect:/cart";
	}
	
	@GetMapping("/deleteitem")
	public String deleteitem(CartDto goodsId, HttpSession session) {
		CartItem cart = (CartItem) session.getAttribute("cart");
		Iterator<CartDto> iterator = cart.getContents().iterator();
		while(iterator.hasNext()) {
			CartDto item = iterator.next();
			if(item.getUserId().equals(goodsId)) {
				iterator.remove();
			}
		}
		return "redirect:/cart";
	}
}
