package com.company.swurameal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.swurameal.dao.mybatis.NoticeDao;
import com.company.swurameal.dto.NoticeDto;

@Service
public class NoticeService {
	@Autowired
	private NoticeDao noticeDao;
	
	public List<NoticeDto> getNotice() {
		return noticeDao.selectAll();
	}
	
	public void insertNotice(NoticeDto noticeDto) {
		noticeDao.insert(noticeDto);
	}
}
