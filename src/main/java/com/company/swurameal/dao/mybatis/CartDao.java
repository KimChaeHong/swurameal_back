package com.company.swurameal.dao.mybatis;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.company.swurameal.dto.CartDto;
import com.company.swurameal.dto.CartGoodsDto;

@Mapper
public interface CartDao {
	
	//userId로 카트 상품목록 가져오기
	public List<CartDto> selectCartByUserId(String userId);
	//userId로 카트 상품목록 가져오기
	public CartDto selectCartItem(CartDto cart);
	//카트에 아이템 추가하기 
	public int insertGoodsToCart(CartDto cart);	
	//중복 아이템 수량 추가
	public int updateGoodsToCart(CartDto cart);
	//카트 아이템 삭제하기
	public int deleteGoodsFromCart(CartDto cart);
	//카트 전체 아이템 삭제하기
	public int deleteAllGoodsFromCart(String userId);
	//카트 수량 카운트
	public List<CartDto> countGoodsFromCart(String userId);
	//주문에 해당하는 상품 불러오는 메서드
	public List<CartGoodsDto> selectCartGoods(HashMap<String, Object> cartGoods);
	
}
