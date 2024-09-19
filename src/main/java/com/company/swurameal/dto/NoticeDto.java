package com.company.swurameal.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class NoticeDto {
	private int noticeId;
	private String userId;
	private String noticeTitle;
	private String noticeContent;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date noticeRegisterDate;
}
