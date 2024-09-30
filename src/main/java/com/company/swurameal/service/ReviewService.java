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
	
	public void writeReview(ReviewDto reviewDto) {
		reviewDao.insert(reviewDto);
	}
	
	public void updateReview(ReviewDto reviewDto) {
		reviewDao.updateReview(reviewDto);
	}
	
	public List<OrderWithItemsDto> getReviewList(Map<String, Object> reviewParams) {
		return reviewDao.selectReviewList(reviewParams);
	}
	
	public List<ReviewDto> getReviewCompleteList(Map<String, Object> reviewParams) {
		return reviewDao.selectReviewCompleteList(reviewParams);
	}
	
	public List<ReviewDto> getReviewByGoods(int goodsId) {
		return reviewDao.selectReviewByGoods(goodsId);
	}
	
	public int getTotalRows(Map<String, Object> reviewParams) {
		return reviewDao.countRows(reviewParams);
	}
	
}