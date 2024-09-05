package com.company.swurameal.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class AnswerDto {
	
	private int answerId;
	private int questionId;
	private String userId;
	private String answerContent;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date answerDate;
	
}
