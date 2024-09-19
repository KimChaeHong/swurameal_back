package com.company.swurameal.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class FaqDto {
	
	private int faqId;
	private String userId;
	private String faqTitle;
	private String faqContent;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date faqRegisterDate;

	
}


