package com.company.swurameal.dto;

import lombok.Data;

@Data
public class CartGoodsDto {
	private String userId;
	private int goodsId;
	private int quantity;
	private String goodsName;
	private int price;
	private String category;
	private String goodsComment;
}
