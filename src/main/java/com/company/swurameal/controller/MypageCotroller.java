package com.company.swurameal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.swurameal.dto.OrderWithItemsDto;
import com.company.swurameal.dto.Pager;
import com.company.swurameal.dto.PickDto;
import com.company.swurameal.dto.UserDto;
import com.company.swurameal.sercurity.CustomUserDetails;
import com.company.swurameal.service.OrderService;
import com.company.swurameal.service.PickService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/mypage")
@Slf4j
public class MypageCotroller {
	@Autowired
	private PickService pickService;
	
	@Autowired
	private OrderService orderService;

	@Secured("ROLE_USER")
	@RequestMapping("/pick")
	public String mypagePick(Model model, Authentication authentication) {
		log.info("찜");
		// 사용자의 모든 정보를 얻고 싶을 경우
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		UserDto user = userDetails.getUserDto();
		String userId = user.getUserId(); // 로그인된 사용자의 userId

		// 찜에 담긴 모든 상품 조회
		List<PickDto> pickGoods = pickService.getCartByUserID(userId);

		log.info(pickGoods.toString());

		// 모델에 사용자와 찜 정보 추가
		model.addAttribute("user", user);
		model.addAttribute("pickGoods", pickGoods);
		
		return "mypage/pick";
	}

	@RequestMapping("/order")
	public String mypageOrder(
		@RequestParam(defaultValue="1") int pageNo,
		@RequestParam(defaultValue="3") int month,
		HttpSession session,
		Model model, 
		Authentication authentication) {
			CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
			UserDto user = userDetails.getUserDto();
			String userId = user.getUserId();
			
			Map<String, Object> orderParams = new HashMap<>();
			orderParams.put("userId", userId);
			orderParams.put("month", month);
			int totalRows = orderService.getTotalRows(orderParams);			
			Pager pager = new Pager(5, 5, totalRows, pageNo);
			orderParams.put("endRowNo", pager.getEndRowNo());
			orderParams.put("startRowNo", pager.getStartRowNo());
			session.setAttribute("pager", pager);
			model.addAttribute("month", month);
			
			List<OrderWithItemsDto> order = orderService.getOrder(orderParams);
			model.addAttribute("order", order);
			return "mypage/order";
	}

	@RequestMapping("/review")
	public String mypageReview(
		@RequestParam(defaultValue="1") int pageNo,
		@RequestParam(defaultValue="0") int month,
		HttpSession session,
		Model model, 
		Authentication authentication
		) {
			CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
			UserDto user = userDetails.getUserDto();
			String userId = user.getUserId();
			
			Map<String, Object> orderParams = new HashMap<>();
			orderParams.put("userId", userId);
			orderParams.put("month", month);
			int totalRows = orderService.getTotalRows(orderParams);			
			Pager pager = new Pager(5, 5, totalRows, pageNo);
			orderParams.put("endRowNo", pager.getEndRowNo());
			orderParams.put("startRowNo", pager.getStartRowNo());
			session.setAttribute("pager", pager);
			model.addAttribute("month", month);
			
			List<OrderWithItemsDto> order = orderService.getOrder(orderParams);
			model.addAttribute("order", order);
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
