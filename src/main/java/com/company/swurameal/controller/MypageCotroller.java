package com.company.swurameal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.swurameal.dto.OrderWithItemsDto;
import com.company.swurameal.dto.PickDto;
import com.company.swurameal.dto.UserDto;
import com.company.swurameal.sercurity.CustomUserDetails;
import com.company.swurameal.service.OrderService;
import com.company.swurameal.service.PickService;
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

	/*@PostMapping("/modifyAjax")
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

	}*/
	
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
		if (userDto.getUserRole() == null || userDto.getUserRole().isEmpty()) {
			userDto.setUserRole("ROLE_USER"); //적절한 기본값으로 설정
		}
		
		//기존 사용자 정보 가져오기
		UserDto existingUser = userService.findUserById(userDto.getUserId());
		//비밀번호가 입력된 경우만 업데이트
		if (userDto.getUserPw() != null && !userDto.getUserPw().isEmpty()) {
			
			userDto.setUserPw(userDto.getUserPw());
		} else {
			//비밀번호가 입력되지 않으면 기존 비밀번호 유지
			userDto.setUserPw(existingUser.getUserPw());
		}
		
		log.info("비밀번호" + userDto.getUserPw() + userDto.toString());
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

}
