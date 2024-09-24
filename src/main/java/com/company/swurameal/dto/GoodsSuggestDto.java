package com.company.swurameal.dto;

import lombok.Data;

@Data
public class GoodsSuggestDto {
	
	private int goodsId;
	private String goodsName;
	private String goodsComment;
	private String category;
	private String subcategory;
	private String price;
	private int countGoods;
	
}
