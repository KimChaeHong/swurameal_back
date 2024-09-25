package com.company.swurameal.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.company.swurameal.dto.OrderWithItemsDto;

@Mapper
public interface OrderDao {
	public List<OrderWithItemsDto> selectOrderByUserId(String userId);
}
