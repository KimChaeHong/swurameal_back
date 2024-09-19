package com.company.swurameal.sercurity;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.company.swurameal.dto.UserDto;

public class CustomUserDetails extends User{
	
	private UserDto user;
	
	public CustomUserDetails(UserDto user,
				List<GrantedAuthority> authorities) {
		super(
				user.getUserId(),
				user.getUserPw(),
				user.isUserEnable(),
				true,true,true,
				authorities
				
				);
		
		this.user= user;
		
	}
	
	public UserDto getUserDto() {
		return user;
	}

}
