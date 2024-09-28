package com.company.swurameal.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ReviewDto {
	private int reviewId;
	private String userId;
	private String userName;
	private int orderId;
	private int goodsId;
	private String goodsName;
	private String reviewContent;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date reviewDate;
	private int reviewStatus;
}
