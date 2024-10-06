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
   
   // 주문한 상품에 대한 정보와 이미지를 가져오는 메서드
   public List<OrderWithItemsDto> selectOrderByUserId(String userId);
   // 주문한 상품에 대한 정보와 이미지를 페이징 처리하며 가져오는 메서드
   public List<OrderWithItemsDto> selectOrderList(Map<String, Object> orderParams);
   // 주문한 상품에 대한 데이터 행수를 가져오는 메서드
   public int countRows(Map<String, Object> orderParams);
   // 주문한 상품에 대한 리뷰작성가능 여부를 업데이트 하는 메서드
   public int updateReviewStatus(ReviewDto reviewDto);
   // 주문을 생성하는 메서드 
   public int insertOrder(OrderDto orderDto);
   // 주문 아이템을 생성하는 메서드
   public int insertOrderItem(OrderItemDto orderItemDto);
   
}
