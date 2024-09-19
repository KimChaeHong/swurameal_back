package com.company.swurameal.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.swurameal.dto.CartItem;
import com.company.swurameal.dto.CartDto;
import com.company.swurameal.dto.GoodsImgDto;
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

	
	@GetMapping
	public String cart(HttpSession session) {
		log.info("장바구니");
		String userId = (String) session.getAttribute("userId");
		List<CartDto> goodsList = cartService.selectGoods(userId);
		session.setAttribute("goodsList", goodsList);
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
	public String cartAdd(CartDto item, HttpSession session) {
		CartItem cart = (CartItem) session.getAttribute("cart");
		if(cart == null) {
			cart = new CartItem();
			session.setAttribute("cart", cart);
		}
		cart.addItem(item);
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
	
	
	@GetMapping("/downloadImage")
	public void downloadImage(int goodsId, HttpServletResponse response) throws Exception {
		GoodsImgDto goods = goodsService.getGoodsAttach(goodsId);
		
		//응답 헤더에 들어가는 Content-Type 파일 확장명을 보고 저장을 자동으로 해주기
		String contentType = goods.getGAttachType();
		response.setContentType(contentType);
		
		//파일로 저장하기 위한 설정				
		String fileName = goods.getGAttachOname();
		String encodingfileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
		response.setHeader("Content-Disposition", "attachment; filename=\""+encodingfileName+"\"");
		
		
		//응답 본문에 파일 데이터를 출력
		OutputStream out = response.getOutputStream();
		out.write(goods.getGAttachData());
		out.flush();
		out.close();
	}
}
