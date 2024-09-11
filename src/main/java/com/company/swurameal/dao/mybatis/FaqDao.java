package com.company.swurameal.dao.mybatis;

import java.util.List;

import com.company.swurameal.dto.FaqDto;

public interface FaqDao {
	public List<FaqDto> getFaq(int faqId);

}
