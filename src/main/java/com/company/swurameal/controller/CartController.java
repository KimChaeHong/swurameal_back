package com.company.swurameal.controller;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.swurameal.dto.CartDto;
import com.company.swurameal.dto.GoodsImgDto;
import com.company.swurameal.dto.UserDto;
import com.company.swurameal.sercurity.CustomUserDetails;
import com.company.swurameal.service.CartService;
import com.company.swurameal.service.GoodsService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CartController {
	@Autowired
	private CartService cartService;
	
	@Autowired
	private GoodsService goodsService; 
	
	// 장바구니 페이지로 이동
	@Secured("ROLE_USER")
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

	//이미지 가져오기
	@GetMapping("/downloadImage")
	public void attachDownload(int goodsId, HttpServletResponse response) throws Exception {
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
