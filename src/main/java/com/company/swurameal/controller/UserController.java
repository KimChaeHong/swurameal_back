package com.company.swurameal.controller;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.swurameal.dto.UserDto;
import com.company.swurameal.sercurity.CustomUserDetails;
import com.company.swurameal.service.UserService;
import com.company.swurameal.service.UserService.JoinResult;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/loginForm")
	public String login() {
		log.info("로그인");
		return "user/loginForm";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("login");
		log.info("로그아웃");
		return "redirect:/user/loginForm";
	}
	
	@RequestMapping("/signup")
	public String signup() {
		log.info("회원가입");
		return "user/signup";
	}

	@PostMapping("/join")
	public String join(UserDto user, Model model) { 
		//계정 활성화
		user.setUserEnable(true);
		//비밀번호 암호화
		log.info(user.getUserPw());
		PasswordEncoder passwordEncoder = 
				PasswordEncoderFactories.createDelegatingPasswordEncoder();
		user.setUserPw(passwordEncoder.encode(user.getUserPw()));
		
		log.info(user.getUserPw());
		log.info(user.toString());
		
		JoinResult joinResult = userService.join(user);
		if (joinResult == JoinResult.FAIL_DUPLICATED_USERID) {
			String errorMessage = "아이디가 존재합니다.";
			model.addAttribute("errorMessage",errorMessage);
			return "user/signup"; 
		}else {
			return "redirect:/user/loginForm";			
		}	
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
	@GetMapping("/modify")
	public String modifyPage(Model model, Authentication authentication) {
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		String userId = userDetails.getUsername(); // 사용자 ID 가져오기
		
		UserDto userInfo = userService.getUserById(userId);
		model.addAttribute("user", userInfo);
		return "mypage/modify";
	}

	//회원 정보 수정
	@Secured("ROLE_USER")
	@PostMapping("/modifyForm")
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
	

	@RequestMapping("/find/id")
	public String findId() {
		log.info("아이디 찾기");
		return "user/findId";
	}
	
	@RequestMapping("find/pw")
	public String findPw() {
		log.info("비밀번호 찾기");
		log.info("확인용");
		return "user/findPassword";
	}
}
