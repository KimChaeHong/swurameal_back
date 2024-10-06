package com.company.swurameal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.swurameal.dao.mybatis.QuestionDao;
import com.company.swurameal.dto.Pager;
import com.company.swurameal.dto.QuestionDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QnaService {
	@Autowired
	private QuestionDao questionDao;
	
	//전체 고객이 쓴 전체 질문 갯수
	public int getTotalRows() {
		int totalRows = questionDao.countRows();
		return totalRows;
	}

	//전체 고객이 쓴 전체 게시물 목록 가져오기
	public List<QuestionDto> getQuestionList(Pager pager) {
		List<QuestionDto> list = questionDao.selectQuestionList(pager);
		
		return list;
	}

	//고객이 질문 작성
	public void writeQuestion(QuestionDto question) {
		questionDao.insert(question);
		int questionId = question.getQuestionId();
	}

	//질문 하나 가져오기
	public QuestionDto getQuestion(int questionId) {
		QuestionDto question = questionDao.selectByQuestionId(questionId);
		return question;
	}
}
