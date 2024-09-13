package com.company.swurameal.controller;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.swurameal.dto.CartDto;
import com.company.swurameal.dto.GoodsImgDto;
import com.company.swurameal.service.CartService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CartController {

	@RequestMapping("/cart")
	public String cart(HttpSession session) {
		List<CartDto> cartList = CartService.selectByGoodsId();
		session.setAttribute("list", cartList);
		log.info("장바구니");
		return "cart/cart";
	}
	

	@RequestMapping("/downloadImage")
	public void getImage(int goodsId, HttpServletResponse response) throws Exception {
		GoodsImgDto img = goodsService.selectByGoodsId(goodsId);

		response.setContentType(img.getGAttachType());
		
		OutputStream out = response.getOutputStream();
		out.write(img.getGAttachData());
		out.flush();
		out.close();
		
	}
}
