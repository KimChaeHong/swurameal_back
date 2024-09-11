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
	
	//상품 가져오기
//	public GoodsDto getGoods(int goodsId) {
//		GoodsDto goods = goodsDao.selectByGoodsId(goodsId);
//		
//		return goods;
//	}
	
	//상품 이미지 가져오기
	

	//전체 상품 목록을 가져오는 메서드
	public List<GoodsDto> getAllGoods() {
		return goodsDao.selectAllGoods();
	}
	// 모든 상품 이미지를 가져오는 메서드
	public List<GoodsImgDto> getAllGoodsImages() {
	    	
	    return goodsDao.selectAllGoodsImages();
	}
	
	   
	

}
