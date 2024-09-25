package com.company.swurameal.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.swurameal.dto.UserDto;
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
