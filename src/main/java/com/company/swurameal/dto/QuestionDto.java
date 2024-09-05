package com.company.swurameal.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class QuestionDto {
	
	private int questionId;
	private String userId;
	private String questionTitle;
	private String questionContent;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date questionDate;
	private String questionStatus;
	

}
