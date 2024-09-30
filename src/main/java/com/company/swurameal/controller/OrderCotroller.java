package com.company.swurameal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
<<<<<<< HEAD
=======
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
>>>>>>> branch 'master' of https://github.com/KimChaeHong/swurameal_back.git

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

<<<<<<< HEAD
import com.company.swurameal.dto.OrderItemDto;
=======
import com.company.swurameal.dto.CartDto;
import com.company.swurameal.dto.CartGoodsDto;
>>>>>>> branch 'master' of https://github.com/KimChaeHong/swurameal_back.git
import com.company.swurameal.sercurity.CustomUserDetails;
<<<<<<< HEAD
import com.company.swurameal.service.OrderService;
=======
import com.company.swurameal.service.CartService;
import com.company.swurameal.service.OrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
>>>>>>> branch 'master' of https://github.com/KimChaeHong/swurameal_back.git

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/order")
public class OrderCotroller {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderService orderService;
	
	//체크된 상품 리스트로 주문서
	@Secured("ROLE_USER")
<<<<<<< HEAD
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public ResponseEntity<Map<String, String>> order(@RequestBody List<OrderItemDto> items,
						Authentication authentication, Model model) {
		
		model.addAttribute("selectedItems", items);
				
		Map<String, String> response = new HashMap<>();
		response.put("redirectUrl", "/order/order");
		return ResponseEntity.ok(response);
=======
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
		    
		    // goodsId 목록 추출
		    List<Integer> goodsIds = goodsData.stream()
		            .map(data -> (Integer) data.get("goodsId"))
		            .collect(Collectors.toList());
		    
		    HashMap<String, Object> cartGoods = new HashMap<String, Object>();
		    cartGoods.put("userId", userInfo);
		    cartGoods.put("goodsIds", goodsIds);
		    List<CartGoodsDto> goods = cartService.getCartGoodsInfo(cartGoods);
		    log.info("세번찾아봐" + goods.toString());
		    // 필요한 비즈니스 로직 처리 후 뷰로 전달
		    model.addAttribute("goods", goods);

		    return "order/order";
	}
	
	//체크된 상품 리스트로 주문
	@Secured("ROLE_USER")
	@RequestMapping("/orderComplete")
	public ResponseEntity<String> completeOrder(
		@RequestBody Map<String, List<CartGoodsDto>> request,
		Authentication authentication
		) {
			CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
			String userInfo = userDetails.getUsername(); //사용자 ID 가져오기
			
		    List<CartGoodsDto> cartGoodsList = request.get("goodsData");
		    orderService.createOrder(userInfo, cartGoodsList);
	
		    for (CartGoodsDto goods : cartGoodsList) {
		    	CartDto cartDto = new CartDto();
		    	cartDto.setUserId(userInfo);
		    	cartDto.setGoodsId(goods.getGoodsId());
		    	cartService.deleteGoodsFromCart(cartDto);
		    }
		    return ResponseEntity.ok("Order received!");
>>>>>>> branch 'master' of https://github.com/KimChaeHong/swurameal_back.git
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String getOrderPage(Model model, Authentication authentication) {
		//세션에서 주문 아이템 가져오기
	    List<OrderItemDto> selectedItems = (List<OrderItemDto>)model.getAttribute("orderItems");
	    model.addAttribute("selectedItems", selectedItems); // JSP에서 사용

	    return "order/order"; // JSP 파일 반환
	}

	
<<<<<<< HEAD
   //DB에 주문 데이터 저장
    @Secured("ROLE_USER")
    @RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
    public ResponseEntity<String> saveOrder(@RequestBody List<OrderItemDto> orderItems, Authentication authentication) {
        String userId = ((CustomUserDetails) authentication.getPrincipal()).getUsername();
        orderService.saveOrder(orderItems, userId);
        orderService.saveOrderItem(orderItems, userId);
        return ResponseEntity.ok("주문이 저장되었습니다.");
    }
=======
	//주문 카트 아이템 삭제
	
	//DB에 데이터 넣기
	
	//비체크시 상품 리스트 조회
	
>>>>>>> branch 'master' of https://github.com/KimChaeHong/swurameal_back.git
}
