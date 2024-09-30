package com.company.swurameal.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.swurameal.dao.mybatis.ReviewDao;
import com.company.swurameal.dto.OrderWithItemsDto;
import com.company.swurameal.dto.ReviewDto;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewDao reviewDao;
	// 리뷰를 작성하는 메서드
	public void writeReview(ReviewDto reviewDto) {
		reviewDao.insert(reviewDto);
	}
	// 리뷰를 수정하는 메서드
	public void editReview(ReviewDto reviewDto) {
		reviewDao.updateReview(reviewDto);
	}
	// 리뷰가 작성되지 않은 주문 상품들에 대한 정보 가져오기
	public List<OrderWithItemsDto> getReviewList(Map<String, Object> reviewParams) {
		return reviewDao.selectReviewList(reviewParams);
	}
	// 리뷰가 작성된 주문 상품들에 대한 정보 가져오기
	public List<ReviewDto> getReviewCompleteList(Map<String, Object> reviewParams) {
		return reviewDao.selectReviewCompleteList(reviewParams);
	}
	// goodsId에 해당하는 리뷰 가져오기
	public List<ReviewDto> getReviewByGoodsId(int goodsId) {
		return reviewDao.selectReviewByGoods(goodsId);
	}
	// userId, 기간(month), 리뷰작성여부에 따른 리뷰데이터 행의 수 가져오기
	public int getTotalRows(Map<String, Object> reviewParams) {
		return reviewDao.countRows(reviewParams);
	}
	
}
