package com.company.swurameal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.company.swurameal.dto.OrderWithItemsDto;
import com.company.swurameal.dto.ReviewDto;

@Mapper
public interface ReviewDao {
	
	// 리뷰를 생성하는 메서드
	public int insert(ReviewDto reviewDto);
	// 리뷰를 수정하는 메서드
	public int updateReview(ReviewDto reviewDto);
	// 리뷰 작성이 되지 않은 주문아이템 가져오는 메서드
	public List<OrderWithItemsDto> selectReviewList(Map<String, Object> reviewParams);
	// 리뷰 작성이 완료 된 주문아이템 가져오는 메서드
	public List<ReviewDto> selectReviewCompleteList(Map<String, Object> reviewParams);
	// 상품 Id로 리뷰를 가져오는 메서드
	public List<ReviewDto> selectReviewByGoods(int goodsId);
	// 리뷰 데이터의 행을 세는 메서드
	public int countRows(Map<String, Object> reviewParams);
	
}
