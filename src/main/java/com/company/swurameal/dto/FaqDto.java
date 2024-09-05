package com.company.swurameal.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class FaqDto {
	
	private int faqId;
	private String adminId;
	private String faqTitle;
	private String faqContent;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate faqRegisterDate;
}
