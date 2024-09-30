package com.company.swurameal.controller;

import java.util.HashMap;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	
	//회원 비활성화
	@GetMapping("/deactivate")
	public String deactivate(Authentication authentication) {
		String userId = authentication.getName();
		userService.deactivateUserById(userId);
		return "redirect:/logout";
	}
	
	//회원 정보 출력
	@Secured("ROLE_USER")
	@GetMapping("/modifyForm")
	public String modifyPage(Model model, Authentication authentication) {
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		String userId = userDetails.getUsername(); // 사용자 ID 가져오기
		
		UserDto userInfo = userService.getUserById(userId);
		model.addAttribute("user", userInfo);
		return "mypage/modify";
	}
	
	//회원 정보 수정
	@Secured("ROLE_USER")
	@PostMapping("/update")
    public String updateUser(UserDto userDto, Authentication authentication) {
		String userId = authentication.getName();
		
		if (userDto.getUserRole() == null || userDto.getUserRole().isEmpty()) {
			userDto.setUserRole("ROLE_USER");
		}
		
		//비밀번호 업데이트 처리
		if (userDto.getUserPw() != null && !userDto.getUserPw().isEmpty()) {
			PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(userDto.getUserPw());
			userDto.setUserPw(hashedPassword);
		} else {
			//비밀번호가 입력되지 않으면 기존 비밀번호 유지
			UserDto existingUser = userService.findUserById(userId);
			userDto.setUserPw(existingUser.getUserPw());
		}
		
		userService.updateByUserId(userDto);
		return "mypage/modify";
	
	}
		
	//Db에서 사용자 정보 가져오기
	@Secured("ROLE_USER")
	@PostMapping("/validatePassword")
	public ResponseEntity<Map<String, Boolean>> validatePassword(@RequestBody Map<String, String> payload, Authentication authentication) {
		 	CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
			String userId = userDetails.getUsername(); // 사용자 ID 가져오기
	        
	        UserDto user = userService.findUserById(userId);
	        
	        Map<String, Boolean> response = new HashMap<>();
	        boolean isValid = false;
	        
	        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder(); //매치하는지 검사
	        if (passwordEncoder.matches(payload.get("password"), user.getUserPw())) {
	        	isValid = true;
	        }
	        response.put("isValid", isValid);
	        return ResponseEntity.ok(response);
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
