package com.company.swurameal.service;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.swurameal.dao.mybatis.OrderDao;
import com.company.swurameal.dto.OrderItemDto;
import com.company.swurameal.dto.OrderWithItemsDto;
import com.company.swurameal.dto.ReviewDto;

@Service
public class OrderService {
	
	@Autowired
	private OrderDao orderdao;
	
	public List<OrderWithItemsDto> getOrder(String userId) {
		return orderdao.selectOrderByUserId(userId);
	}
	
	public List<OrderWithItemsDto> getOrder(Map<String, Object> orderParams) {
		return orderdao.selectOrderList(orderParams);
	}
	
	public int getTotalRows(Map<String, Object> orderParams) {
		return orderdao.countRows(orderParams);
	}
	
	public int updateReviewStatus(ReviewDto reviewDto) {
		return orderdao.updateReviewStatus(reviewDto);
	}
	
	//DB에 주문 데이터 저장
	public void saveOrderItem(List<OrderItemDto> orderItems, String userId) {
		orderdao.insertGoodsToOrderItem(orderItems);
	}

	//DB에 주문 데이터 저장
	public void saveOrder(List<OrderItemDto> orderItems, String userId) {
		orderdao.insertGoodsToOrder(orderItems);
	}
	
}
