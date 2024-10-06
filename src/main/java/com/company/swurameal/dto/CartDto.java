package com.company.swurameal.dto;

import lombok.Data;

@Data
public class CartDto {
	
	private int goodsId;
	private String userId;
	private int quantity;
	private String goodsName;
	private String category;
	private String goodsComment;
	private int price;

}
