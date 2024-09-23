package com.company.swurameal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.swurameal.dao.mybatis.GoodsDao;
import com.company.swurameal.dao.mybatis.PickDao;
import com.company.swurameal.dto.GoodsDto;
import com.company.swurameal.dto.PickDto;

@Service
public class PickService {
	@Autowired
	private PickDao pickDao;
	
	@Autowired
	private GoodsDao goodsDao;
	
	
	// 사용자 ID로 찜에 담긴 모든 상품 조회
	public List<PickDto> getCartByUserID(String userId) {
		List<PickDto> pickItems = pickDao.selectPickByUserId(userId);
		for (PickDto pickItem : pickItems) {
            GoodsDto goods = goodsDao.selectByGoodsID(pickItem.getGoodsId());
            pickItem.setGoodsName(goods.getGoodsName()); // 상품명 설정
            pickItem.setPrice(goods.getPrice()); // 상품 가격 설정
            pickItem.setGoodsComment(goods.getGoodsComment());//상품 코멘트
            pickItem.setCategory(goods.getCategory());//상품 카테고리
            
        }
		
		
		return pickItems;
	}

}
