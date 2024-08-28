package com.company.swurameal.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class UserDto {
	
	private String user_id;
	private String user_name;
	private String user_pw;
	private String user_email;
	private String user_phone;
	private String user_address;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate user_birth;
	
}
