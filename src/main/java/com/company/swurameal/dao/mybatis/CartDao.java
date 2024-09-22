package com.company.swurameal.dao.mybatis;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.company.swurameal.dto.CartDto;

@Mapper
public interface CartDao {
	
	// 사용자 ID로 장바구니에 담긴 모든 상품 조회 (여러 상품이 있을 수 있으므로 List로 반환)
		public List<CartDto> selectCartByUserId(String userId);
	
	//사용자 ID와 상품ID로 장바구니의 특정 상품 조회
	public CartDto selectGoodsInCart(String userId, int goodsId);
	
	//장바구니에 기존 상품 수량 업데이트
	public void updateGoodsQuantity(CartDto existingGoods);

	//장바구니에 새로운 상품 추가
	public void insertGoodsIntoCart(CartDto newGoods);

	


	
	
}

