package com.company.swurameal.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.swurameal.dao.mybatis.CartDao;
import com.company.swurameal.dao.mybatis.GoodsDao;
import com.company.swurameal.dto.CartDto;
import com.company.swurameal.dto.CartGoodsDto;
import com.company.swurameal.dto.GoodsDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CartService {
	@Autowired
	private CartDao cartDao;

	@Autowired
	private GoodsDao goodsDao;

	//상품 정보 가져오기
	public List<CartDto> getGoods(String userId) {		
		List<CartDto> cartItems = cartDao.selectCartByUserId(userId);
		
		for (CartDto item : cartItems) {
			// 각 카트 아이템에 대한 상품 정보 가져오기
			GoodsDto goods = goodsDao.selectByGoodsID(item.getGoodsId());
			item.setGoodsName(goods.getGoodsName());
			item.setCategory(goods.getCategory());
			item.setGoodsComment(goods.getGoodsComment());
			item.setPrice(goods.getPrice());
		}
		return cartItems;
	}

	//카트 아이템 추가하기
	public void addGoodsToCart(CartDto cartItemDto) {

		CartDto dbCartItem = cartDao.selectCartItem(cartItemDto);

		if (dbCartItem != null) {
			dbCartItem.setQuantity(dbCartItem.getQuantity() + 1);
			cartDao.updateGoodsToCart(dbCartItem);
		} else {
			cartDao.insertGoodsToCart(cartItemDto);
		}
	}

	//카트 아이템 삭제하기
	public void deleteGoodsFromCart(CartDto cartItem) {
		cartDao.deleteGoodsFromCart(cartItem);
	}
	
	//카트 전체 아이템 삭제하기
	public void deleteAllGoodsFromCart(String userId) {
		cartDao.deleteAllGoodsFromCart(userId);
		
	}

	//카트 아이템 DB 업데이트
	public void updateGoodsFromCart(CartDto cartItem) {
		cartDao.updateGoodsToCart(cartItem);		
	}
	
	//카트 아이템 수량 가져오기
	/*public int countItemsInCart(String userId) {
		List<CartDto> cartItems = cartDao.selectCartByUserId(userId);
		List<CartDto> cartItems = cartDao.countGoodsFromCart(userId);
		int totalQuantity = 0;
		for (CartDto item : cartItems) {
			totalQuantity += item.getQuantity();
		}
		
		return totalQuantity;
	}*/

	public List<CartDto> getCountItemsInCart(String userId) {
		return cartDao.countGoodsFromCart(userId);
	}
<<<<<<< HEAD
=======
	
	//카트에 해당하는 상품정보 가져오기
	public List<CartGoodsDto> getCartGoodsInfo(HashMap<String, Object> cartGoods) {
		return cartDao.selectCartGoods(cartGoods);
	}
>>>>>>> branch 'master' of https://github.com/KimChaeHong/swurameal_back.git

}
