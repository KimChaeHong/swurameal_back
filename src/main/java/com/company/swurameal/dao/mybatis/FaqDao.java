package com.company.swurameal.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.company.swurameal.dto.FaqDto;

@Mapper
public interface FaqDao {
	public List<FaqDto> getFaq(int faqId);

}
