package com.company.swurameal.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class OrderDto {
	
	private int orderId;
	private String userId;
	private int deliveryId;
	private int totalPrice;
	private String deliveryStatus;
	private String orderStatus;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDate;

}
