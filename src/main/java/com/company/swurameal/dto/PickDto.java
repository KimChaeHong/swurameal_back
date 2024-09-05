package com.company.swurameal.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PickDto {
	
	String userId;
	int goodsID;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date createAt;
}
