package com.company.swurameal.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PickDto {
	
	private String userId;	// user_id 컬럼에 매핑
	private int goodsId;	// goods_id 컬럼에 매핑
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;	// create_at 컬럼에 매핑
	
	private String goodsName; // 상품명
	private int price; // 상품 가격
	private String goodsComment; //상품 코멘트
	private String category; //상품 카테고리
	
}
