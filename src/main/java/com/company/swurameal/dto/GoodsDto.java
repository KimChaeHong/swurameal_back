package com.company.swurameal.dto;

import java.util.List;

import lombok.Data;

@Data
public class GoodsDto {
	
	private int goodsId;
	private String goodsName;
	private String category;
	private String subcategory;
	private int price;
	private String goodsComment;
	private String goodsOrigin;
	private String deliveryInfo;
	private String seller;
	private String saleUnit;
	private String weight;
	private int stockStatus;
	private int status;
	
	private List<GoodsImgDto> goodsImages;

}
