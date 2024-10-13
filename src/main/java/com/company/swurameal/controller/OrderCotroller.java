package com.company.swurameal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.swurameal.dto.CartDto;
import com.company.swurameal.dto.CartGoodsDto;
import com.company.swurameal.sercurity.CustomUserDetails;
import com.company.swurameal.service.CartService;
import com.company.swurameal.service.OrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/order")
public class OrderCotroller {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderService orderService;
	
	//체크된 상품 리스트로 주문서
	@Secured("ROLE_USER")
	@RequestMapping("/order")
	public String navToOrder(
		@RequestParam("goodsData") String goodsDataJson,
		HttpServletRequest request,
		Authentication authentication, 
		Model model
		) throws Exception {
			CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
			String userInfo = userDetails.getUsername(); //사용자 ID 가져오기
			model.addAttribute("user", userDetails.getUserDto());

			// JSON 문자열을 자바 객체로 변환
		    ObjectMapper objectMapper = new ObjectMapper();
		    List<Map<String, Object>> goodsData = objectMapper.readValue(goodsDataJson, new TypeReference<List<Map<String, Object>>>() {});
		    
		    List<Integer> goodsIds = goodsData.stream()
		            .map(data -> (Integer) data.get("goodsId"))
		            .collect(Collectors.toList());
		    
		    HashMap<String, Object> cartGoods = new HashMap<String, Object>();
		    cartGoods.put("userId", userInfo);
		    cartGoods.put("goodsIds", goodsIds);
		    List<CartGoodsDto> goods = cartService.getCartGoodsInfo(cartGoods);
		    log.info("세번찾아봐" + goods.toString());
		    
		    model.addAttribute("goods", goods);

		    return "order/order";
	}
	
	//체크된 상품 리스트로 주문
	@Secured("ROLE_USER")
	@RequestMapping("/orderComplete")
	public ResponseEntity<String> completeOrder(
		@RequestBody List<CartGoodsDto> cartGoodsDto,
		Authentication authentication
		) {
			CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
			String userInfo = userDetails.getUsername();
			
		    orderService.createOrder(userInfo, cartGoodsDto);
	
		    for (CartGoodsDto goods : cartGoodsDto) {
		    	CartDto cartDto = new CartDto();
		    	cartDto.setUserId(userInfo);
		    	cartDto.setGoodsId(goods.getGoodsId());
		    	cartService.deleteGoodsFromCart(cartDto);
		    }
		    return ResponseEntity.ok("잘 되냐");
	}
	
	//주문 카트 아이템 추가
	
	//주문 카트 아이템 삭제
	
	//DB에 데이터 넣기
	
	//비체크시 상품 리스트 조회
	
}
