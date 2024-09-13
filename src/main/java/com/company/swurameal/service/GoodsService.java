package com.company.swurameal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.swurameal.dao.mybatis.GoodsDao;
import com.company.swurameal.dto.GoodsDto;
import com.company.swurameal.dto.GoodsImgDto;
<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/KimChaeHong/swurameal_back.git

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GoodsService{
	
	@Autowired
	private GoodsDao goodsDao;
	
<<<<<<< HEAD
	//상품 하나 가져오기
	/*public GoodsDto getGoods() {
		GoodsDto goods = goodsDao.selectKoreanGoods();
		
=======
	//상품 하나 가져오는 메서드
	/*public GoodsDto getGoods(int goodsId) {
		GoodsDto goods = goodsDao.selectByGoodsID(goodsId);
		return goods;
	}*/

	//상품 사진 가져오는 메서드
	public GoodsImgDto getGoodsAttach(int goodsId) {
		GoodsImgDto goods = goodsDao.selectAttachByGoodsID(goodsId);
>>>>>>> branch 'master' of https://github.com/KimChaeHong/swurameal_back.git
		return goods;
	}*/

	public GoodsDto getGoods(int goodsId) {
		return null;
	}
	
<<<<<<< HEAD
	   
	public List<GoodsDto> selectKoreanGoods() {
		return goodsDao.selectKoreanGoods();
	}

		public GoodsImgDto selectAttachByGoodsId(int goodsId) {
			GoodsImgDto goods = goodsDao.selectAttachByGoodsId(goodsId);
			return goods;

		}
=======
	//전체 상품 목록을 가져오는 메서드
	public List<GoodsDto> getAllGoods() {
		return goodsDao.selectAllGoods();
	}
	
	//상품 카테고리 가져오는 메서드
	public List<GoodsDto> getGoodsCategory(String category){
		return goodsDao.selectGoodsByCategory(category);
	}
	
	
>>>>>>> branch 'master' of https://github.com/KimChaeHong/swurameal_back.git

}
