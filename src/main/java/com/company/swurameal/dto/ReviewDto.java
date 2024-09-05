package com.company.swurameal.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ReviewDto {
	int reviewId;
	String userId;
	int orderId;
	int goodsId;
	String reviewContent;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date reviewDate;
}
