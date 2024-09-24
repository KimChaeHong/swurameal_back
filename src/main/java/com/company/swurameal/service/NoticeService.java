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
	
	// 공지사항 전체 목록을 가져오는 메서드
	public List<NoticeDto> getNotice() {
		return noticeDao.selectList();
	}
	
	// 공지사항 전체 목록을 가져오며 페이징 처리를 함께 해주는 메서드
	public List<NoticeDto> getNotice(Pager pager) {
		return noticeDao.selectListPager(pager);
	}
	
	// 공지사항 하나의 내용을 가져오는 메서드
	public NoticeDto getNoticeById(int noticeId) {
		return noticeDao.selectByNoticeId(noticeId);
	}
	
	// 공지사항을 작성하는 메서드
	public void insertNotice(NoticeDto noticeDto) {
		noticeDao.insert(noticeDto);
	}
	
	// 공지사항을 수정하는 메서드
	public void updateNotice(NoticeDto noticeDto) {
		noticeDao.update(noticeDto);
	}
	
	// 공지사항을 삭제하는 메서드
	public void deleteNotice(int noticeId) {
		noticeDao.delete(noticeId);
	}
	
	// 공지사항의 데이터 갯수를 행으로 세는 메서드
	public int getTotalRows() {
		return noticeDao.countRows();
	}
}
