package com.company.swurameal.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.swurameal.dao.mybatis.OrderDao;
import com.company.swurameal.dto.OrderWithItemsDto;

@Service
public class OrderService {
	
	@Autowired
	private OrderDao orderdao;
	
	public List<OrderWithItemsDto> getOrder(String userId) {
		return orderdao.selectOrderByUserId(userId);
	}
}
