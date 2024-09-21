package com.company.swurameal.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.company.swurameal.dto.NoticeDto;
import com.company.swurameal.dto.Pager;

@Mapper
public interface NoticeDao {
	public List<NoticeDto> selectList();
	public List<NoticeDto> selectListPager(Pager pager);
	public NoticeDto selectByNoticeId(int noticeId);
	public int insert(NoticeDto noticeDto);
	public int update(NoticeDto noticeDto);
	public int delete(int noticeId);
	public int countRows();
}
