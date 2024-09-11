package com.company.swurameal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.company.swurameal.dao.mybatis.KoreanDao;
import com.company.swurameal.dto.GoodsDto;

public class KoreanService {
	@Autowired
	private KoreanDao koreanDao;
	
	/*public GoodsDto getCategoryList(int goodsId) {
		GoodsDto categoryList = cateDao.selectCategory(goodsId);
		return categoryList;
	}*/

	public List<GoodsDto> getGoods(String korean) {
		List<GoodsDto> list = koreanDao.getGoods(korean);
		return list;
	}

}
