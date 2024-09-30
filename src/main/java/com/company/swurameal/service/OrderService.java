package com.company.swurameal.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.swurameal.dao.mybatis.OrderDao;
import com.company.swurameal.dto.CartGoodsDto;
import com.company.swurameal.dto.OrderDto;
import com.company.swurameal.dto.OrderItemDto;
import com.company.swurameal.dto.OrderWithItemsDto;
import com.company.swurameal.dto.ReviewDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderService {
	
	@Autowired
	private OrderDao orderDao;
	
	public List<OrderWithItemsDto> getOrder(String userId) {
		return orderDao.selectOrderByUserId(userId);
	}
	
	public List<OrderWithItemsDto> getOrder(Map<String, Object> orderParams) {
		return orderDao.selectOrderList(orderParams);
	}
	
	public int getTotalRows(Map<String, Object> orderParams) {
		return orderDao.countRows(orderParams);
	}
	
	public int updateReviewStatus(ReviewDto reviewDto) {
		return orderDao.updateReviewStatus(reviewDto);
	}

    public void createOrder(String userId, List<CartGoodsDto> cartGoodsList) {
        
        OrderDto order = new OrderDto();
        order.setUserId(userId);
        order.setDeliveryId(1); // 배송 ID 임의로 1번 나길주로 설정
        order.setDeliveryStatus("PROGRESS"); 
        order.setOrderStatus("COMPLETE"); 
        
        int totalPrice = cartGoodsList.stream()
        		.mapToInt(goods -> goods.getQuantity() * goods.getPrice())
        		.sum();
        order.setTotalPrice(totalPrice);
        
        orderDao.insertOrder(order);
        log.info("잘나오냐" + order.toString());
        
        for (CartGoodsDto goods : cartGoodsList) {
            OrderItemDto orderItem = new OrderItemDto();
            orderItem.setOrderId(order.getOrderId());
            orderItem.setGoodsId(goods.getGoodsId());
            orderItem.setQuantity(goods.getQuantity());
            orderItem.setGoodsPrice(goods.getPrice());
            
            orderDao.insertOrderItem(orderItem);
        }
    }

}
