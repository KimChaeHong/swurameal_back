package com.company.swurameal.dto;

import lombok.Data;

@Data
public class DeliverDto {
	
	private int deliveryId;
	private String userId;
	private String recipient;
	private String address;
	private String detailAddress;
	private int zipcode;

}
