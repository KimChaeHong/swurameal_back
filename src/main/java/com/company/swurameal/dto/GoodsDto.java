package com.company.swurameal.dto;

import lombok.Data;

@Data
public class GoodsDto {
	
	private int goodId;
	private String goodsName;
	private String category;
	private String subcategory;
	private int price;
	private String goodsComent;
	private String goddsOrigin;
	private String deliveryInfo;
	private String seller;
	private String saleUnit;
	private String weight;
	private int stockStatus;
	private int status;

}
