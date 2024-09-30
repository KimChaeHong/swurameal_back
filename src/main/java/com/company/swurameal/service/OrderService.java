package com.company.swurameal.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.swurameal.dao.mybatis.OrderDao;
<<<<<<< HEAD
=======
import com.company.swurameal.dto.CartGoodsDto;
import com.company.swurameal.dto.OrderDto;
>>>>>>> branch 'master' of https://github.com/KimChaeHong/swurameal_back.git
import com.company.swurameal.dto.OrderItemDto;
import com.company.swurameal.dto.OrderWithItemsDto;
import com.company.swurameal.dto.ReviewDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderService {
	
	@Autowired
	private OrderDao orderDao;
	// 주문과 주문에 해당하는 아이템 가져오는 메서드
	public List<OrderWithItemsDto> getOrder(String userId) {
		return orderDao.selectOrderByUserId(userId);
	}
	// 주문과 주문에 해당하는 아이템 가져오는 메서드(오버로딩)
	public List<OrderWithItemsDto> getOrder(Map<String, Object> orderParams) {
		return orderDao.selectOrderList(orderParams);
	}
	// 주문과 주문에 해당하는 아이템을 userId와 기간에 따라 가져오는 메서드
	public int getTotalRows(Map<String, Object> orderParams) {
		return orderDao.countRows(orderParams);
	}
	// 주문한 상품에 대한 리뷰 작성 여부를 업데이트 하는 메서드
	public int updateReviewStatus(ReviewDto reviewDto) {
		return orderDao.updateReviewStatus(reviewDto);
	}
<<<<<<< HEAD
	
	//DB에 주문 데이터 저장
	public void saveOrderItem(List<OrderItemDto> orderItems, String userId) {
		orderdao.insertGoodsToOrderItem(orderItems);
	}

	//DB에 주문 데이터 저장
	public void saveOrder(List<OrderItemDto> orderItems, String userId) {
		orderdao.insertGoodsToOrder(orderItems);
	}
	
=======
	// 주문서에서 주문을 생성하는 메서드(주문과 주문아이템 생성)
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

>>>>>>> branch 'master' of https://github.com/KimChaeHong/swurameal_back.git
}
