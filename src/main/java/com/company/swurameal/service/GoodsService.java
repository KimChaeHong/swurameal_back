package com.company.swurameal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.swurameal.dao.mybatis.GoodsDao;
import com.company.swurameal.dto.GoodsDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GoodsService{
	
	@Autowired
	private GoodsDao goodsDao;
	
	//상품 하나 가져오기
	public GoodsDto getGoods(int goodsId) {
		GoodsDto goods = goodsDao.selectByGoodsId(goodsId);
		
		return goods;
	}
	

}
