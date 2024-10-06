package com.company.swurameal.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.swurameal.dto.OrderWithItemsDto;
import com.company.swurameal.dto.Pager;
import com.company.swurameal.dto.PickDto;
import com.company.swurameal.dto.ReviewDto;
import com.company.swurameal.dto.UserDto;
import com.company.swurameal.sercurity.CustomUserDetails;
import com.company.swurameal.service.OrderService;
import com.company.swurameal.service.PickService;
import com.company.swurameal.service.ReviewService;
import com.company.swurameal.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/mypage")
@Slf4j
public class MypageCotroller {
	@Autowired
	private PickService pickService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ReviewService reviewService;

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
	public String navToMyPageOrder(
		@RequestParam(defaultValue="1") int pageNo,
		@RequestParam(defaultValue="3") int month,
		HttpSession session,
		Model model, 
		Authentication authentication) {
			CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
			UserDto user = userDetails.getUserDto();
			String userId = user.getUserId();
			model.addAttribute("user", userDetails.getUserDto());
			
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
	public String navToMyPageReview(
		@RequestParam(defaultValue="1") int pageNo,
		@RequestParam(defaultValue="0") int month,
		@RequestParam(defaultValue="0") int reviewStatus,
		HttpSession session,
		Model model, 
		Authentication authentication
		) {
			CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
			UserDto user = userDetails.getUserDto();
			String userId = user.getUserId();
			model.addAttribute("user", userDetails.getUserDto());
			
			Map<String, Object> reviewParams = new HashMap<>();
			reviewParams.put("userId", userId);
			reviewParams.put("month", month);
			reviewParams.put("reviewStatus", reviewStatus);
			
			int totalRows = reviewService.getTotalRows(reviewParams);
			Pager pager = new Pager(5, 5, totalRows, pageNo);
			reviewParams.put("endRowNo", pager.getEndRowNo());
			reviewParams.put("startRowNo", pager.getStartRowNo());
			model.addAttribute("pager", pager);
			model.addAttribute("month", month);
			
			LocalDate currentDate = LocalDate.now();
			model.addAttribute("currentDate", currentDate);
			
			List<OrderWithItemsDto> review = reviewService.getReviewList(reviewParams);
			model.addAttribute("review", review);
			return "mypage/review";
	}
	
	@PostMapping("/writeReview")
	public String writeReview(
		@ModelAttribute ReviewDto reviewDto,
		Authentication authentication) {
			CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
			UserDto user = userDetails.getUserDto();
			String userId = user.getUserId();
			reviewDto.setUserId(userId);
			reviewDto.setReviewStatus(1);
			reviewService.writeReview(reviewDto);
			orderService.updateReviewStatus(reviewDto);
		
			return "mypage/review";
	}
	
	@GetMapping("/reviewCompleteList")
	public String navToReviewCompleteList(
		@RequestParam(defaultValue="1") int pageNo,
		@RequestParam(defaultValue="0") int month,
		@RequestParam(defaultValue="1") int reviewStatus,
		HttpSession session,
		Model model,
		Authentication authentication) {
			CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
			UserDto user = userDetails.getUserDto();
			String userId = user.getUserId();
			model.addAttribute("user", userDetails.getUserDto());
			
			Map<String, Object> reviewParams = new HashMap<>();
			reviewParams.put("userId", userId);
			reviewParams.put("month", month);
			reviewParams.put("reviewStatus", reviewStatus);
			
			int totalRows = reviewService.getTotalRows(reviewParams);
			Pager pager = new Pager(5, 5, totalRows, pageNo);
			reviewParams.put("endRowNo", pager.getEndRowNo());
			reviewParams.put("startRowNo", pager.getStartRowNo());
			model.addAttribute("pager", pager);
			model.addAttribute("month", month);
			
			List<ReviewDto> review = reviewService.getReviewCompleteList(reviewParams);
			model.addAttribute("review", review);
			return "mypage/reviewCompleteList";
	}
	
	@PostMapping("/editReview")
	public String editReview(
		@ModelAttribute ReviewDto reviewDto,
		Authentication authentication) {
			CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
			UserDto user = userDetails.getUserDto();
			String userId = user.getUserId();
			reviewDto.setUserId(userId);
			log.info("잘되냐" + reviewDto.toString());
			reviewService.editReview(reviewDto);
		
			return "mypage/reviewCompleteList";
	}
			
}
