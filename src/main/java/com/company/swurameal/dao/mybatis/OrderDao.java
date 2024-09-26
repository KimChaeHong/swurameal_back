package com.company.swurameal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.company.swurameal.dto.OrderWithItemsDto;

@Mapper
public interface OrderDao {
	public List<OrderWithItemsDto> selectOrderByUserId(String userId);
	public List<OrderWithItemsDto> selectOrderList(Map<String, Object> orderParams);
	public int countRows(Map<String, Object> orderParams);
}
