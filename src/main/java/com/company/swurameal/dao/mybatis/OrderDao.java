package com.company.swurameal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.company.swurameal.dto.OrderDto;
import com.company.swurameal.dto.OrderItemDto;
import com.company.swurameal.dto.OrderWithItemsDto;
import com.company.swurameal.dto.ReviewDto;

@Mapper
public interface OrderDao {
	public List<OrderWithItemsDto> selectOrderByUserId(String userId);
	public List<OrderWithItemsDto> selectOrderList(Map<String, Object> orderParams);
	public int countRows(Map<String, Object> orderParams);
	public int updateReviewStatus(ReviewDto reviewDto);
	public int insertOrder(OrderDto orderDto);
	public int insertOrderItem(OrderItemDto orderItemDto);
}
