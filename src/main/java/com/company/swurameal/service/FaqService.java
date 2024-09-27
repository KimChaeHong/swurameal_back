package com.company.swurameal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.swurameal.dao.mybatis.FaqDao;
import com.company.swurameal.dto.FaqDto;
import com.company.swurameal.dto.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FaqService {
	@Autowired
	private FaqDao faqDao;
	//FAQ 전체 목록을 가져오는 메서드
	public List<FaqDto> getFaq(String faq) {
		List<FaqDto> list = faqDao.getFaq(faq);
		return list;
	}	
	//FAQ 전체 목록을 가져오며 페이징 처리를 함께 해주는 메서드
	public List<FaqDto> getFaq(Pager pager) {
		return faqDao.selectListPager(pager);
	}	
	//FAQ 하나의 내용을 가져오는 메서드
	public FaqDto getFaqById(int faqId) {
		return faqDao.selectByFaqId(faqId);
	}
	//관리자 FAQ 작성하는 메서드
	public void insertFaq(FaqDto faqDto) {
		faqDao.insert(faqDto);		
	}
	//FAQ 수정하는 메서드
	public void updateFaq(FaqDto faqDto) {
		faqDao.update(faqDto);		
	}
	//FAQ 삭제하는 메서드
	public void deleteFaq(int faqId) {
		faqDao.delete(faqId);		
	}
	//FAQ 데이터 갯수를 행으로 세는 메서드
	public int getTotalRows() {
		return faqDao.countRows();
		}
}
