package com.company.swurameal.dto;

import lombok.Data;

@Data
public class GoodsImgDto {
	
	private int goodsImgId;
	private int goodsId;
	private String goodsName;
	private String gAttachOname;
	private String gAttachType;
	private byte[] gAttachData;
	private String imgRole;
	
}
