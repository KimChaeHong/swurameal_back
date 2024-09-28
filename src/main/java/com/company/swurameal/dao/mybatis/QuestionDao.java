package com.company.swurameal.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.company.swurameal.dto.Pager;
import com.company.swurameal.dto.QuestionDto;

@Mapper
public interface QuestionDao {
	
	//질문 갯수
	public int countRows();

	//전체 고객이 쓴 질문 목록
	public List<QuestionDto> selectQuestionList(Pager pager);

	//질문 작성
	public void insert(QuestionDto question);

	
	

}
