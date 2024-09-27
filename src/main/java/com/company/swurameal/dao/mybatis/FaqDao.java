package com.company.swurameal.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.company.swurameal.dto.FaqDto;
import com.company.swurameal.dto.Pager;

@Mapper
public interface FaqDao {
	//FAQ 목록
	public List<FaqDto> getFaq(String faq);
	//FAQ 전체 목록을 가져오며 페이징 처리
	public List<FaqDto> selectListPager(Pager pager);
	//FAQ 하나 가져오기
	public FaqDto selectByFaqId(int faqId);
	//FAQ 작성
	public void insert(FaqDto faqDto);
	//FAQ 수정
	public int update(FaqDto faqDto);
	//FAQ 삭제
	public void delete(int faqId);
	//FAQ 데이터 갯수 카운트
	public int countRows();

}
