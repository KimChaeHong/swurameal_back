package com.company.swurameal.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.company.swurameal.dto.NoticeDto;

@Mapper
public interface NoticeDao {
	public List<NoticeDto> selectAll();
	public int insert(NoticeDto noticeDto);
	public int update(NoticeDto noticeDto);
	public int delete(int noticeId);
}
