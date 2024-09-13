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
	
	//상품 하나 가져오기
	/*public GoodsDto getGoods() {
		GoodsDto goods = goodsDao.selectKoreanGoods();
		
		return goods;
	}*/

	public GoodsDto getGoods(int goodsId) {
		return null;
	}
	
	   
	public List<GoodsDto> selectKoreanGoods() {
		return goodsDao.selectKoreanGoods();
	}

		public GoodsImgDto selectAttachByGoodsId(int goodsId) {
			GoodsImgDto goods = goodsDao.selectAttachByGoodsId(goodsId);
			return goods;

		}

}
