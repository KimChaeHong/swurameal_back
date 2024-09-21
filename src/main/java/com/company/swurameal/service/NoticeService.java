package com.company.swurameal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.swurameal.dao.mybatis.NoticeDao;
import com.company.swurameal.dto.NoticeDto;
import com.company.swurameal.dto.Pager;

@Service
public class NoticeService {
	@Autowired
	private NoticeDao noticeDao;
	
	public List<NoticeDto> getNotice() {
		return noticeDao.selectList();
	}
	
	public List<NoticeDto> getNotice(Pager pager) {
		return noticeDao.selectListPager(pager);
	}
	
	public NoticeDto getNoticeById(int noticeId) {
		return noticeDao.selectByNoticeId(noticeId);
	}
	
	public void insertNotice(NoticeDto noticeDto) {
		noticeDao.insert(noticeDto);
	}
	
	public void updateNotice(NoticeDto noticeDto) {
		noticeDao.update(noticeDto);
	}
	
	public void deleteNotice(int noticeId) {
		noticeDao.delete(noticeId);
	}
	
	public int getTotalRows() {
		return noticeDao.countRows();
	}
}
