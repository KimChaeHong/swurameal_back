package com.company.swurameal.dto;

import lombok.Data;

@Data
public class CartDto {
	private String userId;
	private int goodsId;
	private int quantity;
	private String goodsName; // 상품명
	private int price; // 상품 가격
	private String goodsComment; //상품 코멘트
	private String category; //상품 카테고리

}

