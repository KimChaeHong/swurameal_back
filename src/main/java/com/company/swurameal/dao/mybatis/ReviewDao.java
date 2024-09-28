package com.company.swurameal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.company.swurameal.dto.OrderWithItemsDto;
import com.company.swurameal.dto.ReviewDto;

@Mapper
public interface ReviewDao {
	
	public int insert(ReviewDto reviewDto);
	public List<OrderWithItemsDto>selectReviewList(Map<String, Object> reviewParams);
	public int countRows(Map<String, Object> reviewParams);
	
}
