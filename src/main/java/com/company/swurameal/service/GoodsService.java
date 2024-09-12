package com.company.swurameal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.swurameal.dao.mybatis.GoodsDao;
import com.company.swurameal.dto.GoodsDto;
import com.company.swurameal.dto.GoodsImgDto;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GoodsService{
	
	@Autowired
	private GoodsDao goodsDao;
	
	//상품 하나 가져오는 메서드
	public GoodsDto getGoods(int goodsId) {
		GoodsDto goods = goodsDao.selectByGoodsID(goodsId);
		return goods;
	}

	//전체 상품 목록을 가져오는 메서드
	public List<GoodsDto> getAllGoods() {
		return goodsDao.selectAllGoods();
	}	
	
	//상품 사진 가져오는 메서드
	public GoodsImgDto getGoodsAttach(int goodsId) {
		GoodsImgDto goods = goodsDao.selectAttachByGoodsID(goodsId);
		return goods;
	}

}
