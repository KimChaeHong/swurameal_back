package com.company.swurameal.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class QuestionWriteForm {
	
	private String questionTitle;
	private String questionContent;
	private MultipartFile qattach;
}
