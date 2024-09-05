package com.company.swurameal.dto;

import lombok.Data;

@Data
public class CartDto {
	private String userId;
	private int goodsId;
	private int quantity;

}
