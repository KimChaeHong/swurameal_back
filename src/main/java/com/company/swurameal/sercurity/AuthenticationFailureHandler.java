package com.company.swurameal.sercurity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	
	public void onAuthenticationFailure(
			HttpServletRequest request, 
			HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		log.info("실패");
		log.info(exception.getMessage());
		setDefaultFailureUrl("/user/loginForm");
		
		super.onAuthenticationFailure(request, response, exception);
		
		
	}

}
