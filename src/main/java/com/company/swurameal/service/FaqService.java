package com.company.swurameal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.swurameal.dao.mybatis.FaqDao;
import com.company.swurameal.dto.FaqDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FaqService {
	@Autowired
	private FaqDao faqDao;
	
	public List<FaqDto> getFaq(String faq) {
		List<FaqDto> list = faqDao.getFaq(faq);
		return list;
	}

}
