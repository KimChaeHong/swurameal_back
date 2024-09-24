package com.company.swurameal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.swurameal.dto.OrderWithItemsDto;
import com.company.swurameal.dto.UserDto;
import com.company.swurameal.sercurity.CustomUserDetails;
import com.company.swurameal.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/mypage")
@Slf4j
public class MypageCotroller {
	
	@Autowired
	private OrderService orderService;

	@Secured("ROLE_USER")
	@RequestMapping("/pick")
	public String mypagePick() {
		log.info("찜");
		return "mypage/pick";
	}

	@RequestMapping("/order")
	public String mypageOrder(Model model, Authentication authentication) {
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		UserDto user = userDetails.getUserDto();
		String userId = user.getUserId();
		
		List<OrderWithItemsDto> order = orderService.getOrder(userId);
		model.addAttribute("order", order);
		log.info("주문내역");
		return "mypage/order";
	}

	@RequestMapping("/review")
	public String mypageReview() {
		log.info("후기");
		return "mypage/review";
	}

	@RequestMapping("/modify")
	public String mypageModify() {

		log.info("개인정보수정");
		return "mypage/modify";
	}

	@PostMapping("/modifyAjax")
	public void requestModify(UserDto userdto, HttpServletResponse response) throws IOException {
		log.info(userdto.toString());

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "OK");
		String json = jsonObject.toString();

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();

		pw.println(json);
		pw.flush();
		pw.close();

	}

}
