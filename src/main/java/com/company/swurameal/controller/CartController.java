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
import com.company.swurameal.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService cartService;
	
	@Autowired
	private UserService userService;

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

		//삭제할 아이템 생성
		CartDto cartItem = new CartDto();
		cartItem.setUserId(userInfo);
		cartItem.setGoodsId(goodsId);

		cartService.deleteGoodsFromCart(cartItem);
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
	@GetMapping("/itemCount")
	public ResponseEntity<List<CartDto>> getItemCount(Authentication authentication) {
		
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		String userInfo = userDetails.getUsername(); // 사용자 ID 가져오기
		
		/*Map<Long, Integer> itemCountMap = new HashMap<>();*/
		
		//사용자 카트에서 아이템 수를 조회
		/*List<CartDto> itemCountMap = cartService.getCountItemsInCart(userInfo);*/
		/*for (CartDto item : cartItem) {
			itemCountMap.put((long)item.getGoodsId(), item.getQuantity());
		}*/
		List<CartDto> itemCountMap = cartService.getCountItemsInCart(userInfo);
		return ResponseEntity.ok(itemCountMap);
	}
	
	/*//수량 업데이트
	@GetMapping("/itemCount")
	public ResponseEntity<Map<Long, Integer>> getItemCount(HttpSession session) {
		//세션에서 userId 가져오기
		String userId = (String) session.getAttribute("userId");
		Map<Long, Integer> itemCountMap = new HashMap<>();
		
		if (userId != null) {
			//사용자 카트에서 아이템 수를 조회
			List<CartDto> cartItem = cartService.getCountItemsInCart(userId);
			for (CartDto item : cartItem) {
				itemCountMap.put((long)item.getGoodsId(), item.getQuantity());
			}
		}
		
		return ResponseEntity.ok(itemCountMap);
	}*/
	
}
