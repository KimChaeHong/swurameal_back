package com.company.swurameal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.swurameal.dao.mybatis.CartDao;
import com.company.swurameal.dto.CartDto;

@Service
public class CartService {
	@Autowired
	private CartDao cartDao;
	
	public List<CartDto> selectGoods(String userId) {
		List<CartDto> cartList = cartDao.selectByGoodsId(userId);
		return cartList;
	}

}
