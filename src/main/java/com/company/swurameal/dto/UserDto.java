package com.company.swurameal.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class UserDto {
	
	private String userId;
	private String userName;
	private String userPw;
	private String userEmail;
	private String userPhone;
	private String userAddress;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate userBirth;
	
	private String userRole;
	private int userEnable;
	
}
