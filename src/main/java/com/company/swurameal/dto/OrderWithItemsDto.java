package com.company.swurameal.dto;

import java.util.Date;

import lombok.Data;

@Data
public class OrderWithItemsDto {
	
	private int orderId;
	private String userId;
	private String delivery_status;
	private String orderStatus;
	private Date orderDate;
	private int goodsId;
	private int goodsPrice;
	private int reviewStatus;
	private String goodsName;
	private String gAttachOname;
	private String gAttachType;
	private byte[] gAttachData;
	private String imgRole;
	
}
