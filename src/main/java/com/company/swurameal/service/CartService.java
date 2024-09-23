package com.company.swurameal.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.swurameal.dao.mybatis.CartDao;
import com.company.swurameal.dao.mybatis.GoodsDao;
import com.company.swurameal.dto.CartDto;
import com.company.swurameal.dto.GoodsDto;
import com.company.swurameal.dto.GoodsImgDto;


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
    

	
	//장바구니 상품 추가
	public void addGoodsToCart(String userId, int goodsId, int quantity) {
		// 장바구니에서 기존 상품을 조회
		CartDto existingGoods = cartDao.selectGoodsInCart(userId, goodsId);
        
		if (existingGoods != null) {
	        // 기존 상품이 있으면 수량 증가
	        int updatedQuantity = existingGoods.getQuantity() + quantity;
	        existingGoods.setQuantity(updatedQuantity);
	        cartDao.updateGoodsQuantity(existingGoods);
	    } else {
	        // 새로운 상품을 장바구니에 추가
	        CartDto newGoods = new CartDto();
	        newGoods.setUserId(userId);
	        newGoods.setGoodsId(goodsId);
	        newGoods.setQuantity(quantity);
	        cartDao.insertGoodsIntoCart(newGoods);
	    }
    }

}
