package com.company.swurameal.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.company.swurameal.dto.NoticeDto;
import com.company.swurameal.dto.Pager;

@Mapper
public interface NoticeDao {
	
	// 공지사항 전체를 불러오는 메서드
	public List<NoticeDto> selectList();
	// 공지사항 항목을 페이지 선택되었을 때 그에 맞게 보여주는 메서드
	public List<NoticeDto> selectListPager(Pager pager);
	// 공지사항 하나를 가져오는 메서드
	public NoticeDto selectByNoticeId(int noticeId);
	// 공지사항을 작성하는 메서드
	public int insert(NoticeDto noticeDto);
	// 공지사항을 수정하는 메서드
	public int update(NoticeDto noticeDto);
	// 공지사항을 삭제하는 메서드
	public int delete(int noticeId);
	// 공지사항 데이터의 총 행의 수를 가져오는 메서드
	public int countRows();
	
}
