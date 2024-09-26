package com.company.swurameal.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.swurameal.dao.mybatis.GoodsDao;
import com.company.swurameal.dao.mybatis.GoodsImgDao;
import com.company.swurameal.dto.GoodsDto;
import com.company.swurameal.dto.GoodsImgDto;
import com.company.swurameal.dto.GoodsSuggestDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GoodsService {

	@Autowired
	private GoodsDao goodsDao;

	@Autowired
	private GoodsImgDao goodsImgDao;

	// 상품 하나 가져오는 메서드
	public GoodsDto getGoodsById(int goodsId) {
		GoodsDto goods = goodsDao.selectByGoodsID(goodsId);
		return goods;
	}

	// 상품 사진 goodsImgId로 가져오는 메서드
	public GoodsImgDto getGoodsAttach(int goodsImgId) {
		GoodsImgDto goods = goodsDao.selectAttachByGoodsImgId(goodsImgId);
		return goods;
	}

	// 상품 사진 imgRole에 따라 가져오는 메서드
	public GoodsImgDto getGoodsAttachByRole(GoodsImgDto goodsImgDto) {
		GoodsImgDto goods = goodsDao.selectAttachByImgRole(goodsImgDto);
		return goods;
	}

	// 전체 상품 목록을 가져오는 메서드
	public List<GoodsDto> getAllGoods() {
		return goodsDao.selectAllGoods();
	}

	// 상품 카테고리 가져오는 메서드
	public List<GoodsDto> getGoodsCategory(String category) {
		return goodsDao.selectGoodsByCategory(category);
	}

	// 상품 서브 카테고리 가져오는 메서드
	public List<GoodsDto> getGoodsSubCategory(String subCategory) {
		return goodsDao.selectGoodsBySubCategory(subCategory);
	}

	// 상품 추천 메서드
	public List<GoodsSuggestDto> getGoodsBySuggest(GoodsDto goodsDto) {
		return goodsDao.selectGoodsBySuggest(goodsDto);
	}

	// 알콜 추천 메서드
	public List<GoodsSuggestDto> getAlcoholBySuggest(GoodsDto goodsDto) {
		String category = goodsDto.getCategory();
		switch (category) {
		case "한식":
			goodsDto.setSubcategory("증류주");
			break;
		case "양식":
			goodsDto.setSubcategory("과실주");
			break;
		case "분식":
			goodsDto.setSubcategory("탁주");
			break;
		default:
			goodsDto.setSubcategory("떡볶이");
			break;
		}
		return goodsDao.selectAlcoholBySuggest(goodsDto);
	}

	// 상품 DB에 등록
	@Transactional // 서비스 동작 처리 - 테이블 저장이 다 저장 되면 성공 하나라도 안되면 실패
	public void registGoods(GoodsDto goods, List<GoodsImgDto> imgList) {
		// goods 테이블
		goodsDao.insert(goods);

		// goodsImg 테이블
		for (GoodsImgDto goodsImg : imgList) {
			goodsImg.setGoodsId(goods.getGoodsId());
			goodsImgDao.insert(goodsImg);
		}
	}

	// 상품 업데이트
	public void updateGoods(GoodsDto goods) {
		goodsDao.update(goods);

	}


}
