package com.company.swurameal.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class GoodsUpdateForm {
	
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
	private int stock;
	private int status;
	
	private MultipartFile mainAttach;
	private MultipartFile descAttach;
	private MultipartFile detailAttach;

}
