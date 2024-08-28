package com.company.swurameal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {
	
	@RequestMapping("/signup")
	public String signup() {
		log.info("회원가입");
		return "user/signup";
	}
	
	@RequestMapping("/login")
	public String login() {
		log.info("로그인");
		return "user/login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
	    HttpSession session = request.getSession(false);
	    if (session != null) {
	        session.invalidate(); // 세션 무효화
	    }
	    log.info("로그아웃");
	    return "redirect:/"; // 로그아웃 후 홈 페이지로 리다이렉트
	}

	
	@RequestMapping("/find/id")
	public String findId() {
		log.info("아이디 찾기");
		return "user/findId";
	}
	
	@RequestMapping("find/pw")
	public String findPw() {
		log.info("비밀번호 찾기");
		return "user/findPassword";
	}

	

}
