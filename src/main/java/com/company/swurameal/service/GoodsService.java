package com.company.swurameal.service;

import java.util.List;
import java.util.Map;

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
	public GoodsDto getGoodsById(int goodsId) {
		GoodsDto goods = goodsDao.selectByGoodsID(goodsId);
		return goods;
	}

	//상품 사진 가져오는 메서드
	public GoodsImgDto getGoodsAttach(int goodsId) {
		GoodsImgDto goods = goodsDao.selectAttachByGoodsID(goodsId);
		return goods;
	}
	
	//상품 사진 imgRole에 따라 가져오는 메서드
	public GoodsImgDto getGoodsAttachByRole(GoodsImgDto goodsImgDto) {
		GoodsImgDto goods = goodsDao.selectAttachByImgRole(goodsImgDto);
		return goods;
	}
	
	//전체 상품 목록을 가져오는 메서드
	public List<GoodsDto> getAllGoods() {
		return goodsDao.selectAllGoods();
	}
	
	//상품 카테고리 가져오는 메서드
	public List<GoodsDto> getGoodsCategory(String category){
		return goodsDao.selectGoodsByCategory(category);
	}
	
	//상품 서브 카테고리 가져오는 메서드
	public List<GoodsDto> getGoodsSubCategory(String subCategory) {
		return goodsDao.selectGoodsBySubCategory(subCategory);
	}
}
