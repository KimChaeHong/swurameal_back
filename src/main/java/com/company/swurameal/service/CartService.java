package com.company.swurameal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.swurameal.dao.mybatis.CartDao;
import com.company.swurameal.dao.mybatis.GoodsDao;
import com.company.swurameal.dto.CartDto;
import com.company.swurameal.dto.GoodsDto;



@Service
public class CartService {
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private GoodsDao goodsDao;
	
	// 사용자 ID로 장바구니에 담긴 모든 상품 조회
    public List<CartDto> getCartByUserID(String userId) {
        List<CartDto> cartItems = cartDao.selectCartByUserId(userId);

        // 각 장바구니 항목에 해당하는 상품 정보 추가
        for (CartDto cartItem : cartItems) {
            GoodsDto goods = goodsDao.selectByGoodsID(cartItem.getGoodsId());
            cartItem.setGoodsName(goods.getGoodsName()); // 상품명 설정
            cartItem.setPrice(goods.getPrice()); // 상품 가격 설정
            cartItem.setGoodsComment(goods.getGoodsComment());//상품 코멘트
            cartItem.setCategory(goods.getCategory());//상품 카테고리
            
        }
        return cartItems;
    }
}
