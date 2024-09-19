package com.company.swurameal.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.company.swurameal.dto.FaqDto;

@Mapper
public interface FaqDao {
	public List<FaqDto> getFaq(String faq);

	/*public List<FaqDto> selectList(FaqPager pager);

	public int countRows();*/

}
