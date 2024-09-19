package com.company.swurameal.sercurity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler{
	
	@Override
	public void onLogoutSuccess(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Authentication authentication) throws IOException, ServletException {
		
		log.info("로그아웃");
		setDefaultTargetUrl("/user/login");
		
		super.onLogoutSuccess(request, response, authentication);
		
	}
	

}
