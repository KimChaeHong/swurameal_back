package com.company.swurameal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.swurameal.dto.OrderItemDto;
import com.company.swurameal.sercurity.CustomUserDetails;
import com.company.swurameal.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/order")
public class OrderCotroller {
	@Autowired
	private OrderService orderService;
	
	//체크된 상품 리스트 조회
	@Secured("ROLE_USER")
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public ResponseEntity<Map<String, String>> order(@RequestBody List<OrderItemDto> items,
						Authentication authentication, Model model) {
		
		model.addAttribute("selectedItems", items);
				
		Map<String, String> response = new HashMap<>();
		response.put("redirectUrl", "/order/order");
		return ResponseEntity.ok(response);
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String getOrderPage(Model model, Authentication authentication) {
		//세션에서 주문 아이템 가져오기
	    List<OrderItemDto> selectedItems = (List<OrderItemDto>)model.getAttribute("orderItems");
	    model.addAttribute("selectedItems", selectedItems); // JSP에서 사용

	    return "order/order"; // JSP 파일 반환
	}

	
   //DB에 주문 데이터 저장
    @Secured("ROLE_USER")
    @RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
    public ResponseEntity<String> saveOrder(@RequestBody List<OrderItemDto> orderItems, Authentication authentication) {
        String userId = ((CustomUserDetails) authentication.getPrincipal()).getUsername();
        orderService.saveOrder(orderItems, userId);
        orderService.saveOrderItem(orderItems, userId);
        return ResponseEntity.ok("주문이 저장되었습니다.");
    }
}
