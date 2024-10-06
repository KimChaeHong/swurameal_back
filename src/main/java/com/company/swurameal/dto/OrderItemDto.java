package com.company.swurameal.dto;

import lombok.Data;

@Data
public class OrderItemDto {
	private int orderId;
	private int goodsId;
	private int quantity;
	private int goodsPrice;
	
	private String goodsName;
	private String category;
	private String goodsComment;
	private int price;
}
