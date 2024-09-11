package com.company.swurameal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.swurameal.dao.mybatis.CategoryDao;
import com.company.swurameal.dto.GoodsDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryService {
	@Autowired
	private CategoryDao cateDao;
	
	//카테고리 가져오기
	public GoodsDto getCategoryList(int goodsId){
		GoodsDto categoryList = cateDao.selectCategory(goodsId);
		return categoryList;
	}

	public GoodsDto selectCategory(int goodsId) {
		return null;
	}

	/*public List<GoodsDto> getGoods(String korean) {
		List<GoodsDto> list = cateDao.getGoods(korean);
		return list;
	}*/
}
