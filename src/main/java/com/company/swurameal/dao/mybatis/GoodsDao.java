package com.company.swurameal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.company.swurameal.dto.GoodsDto;
import com.company.swurameal.dto.GoodsImgDto;
import com.company.swurameal.dto.GoodsSuggestDto;


@Mapper
public interface GoodsDao {

	//상품 하나 가져오기
	public GoodsDto selectByGoodsID(int goodsId);

	//상품 이미지 가져오기
	public GoodsImgDto selectAttachByGoodsID(int goodsId);
	
	//상품 이미지 imgRole에 따라 가져오기
	public GoodsImgDto selectAttachByImgRole(GoodsImgDto goodsImgDto);

	//전체 상품 가져오기
	public List<GoodsDto> selectAllGoods();
	
	//상품 카테고리 가져오기
	public List<GoodsDto> selectGoodsByCategory(String category);
	
	//상품 서브 카테고리 가져오기
	public List<GoodsDto> selectGoodsBySubCategory(String subcategory);
	
	//상품 추천 카테고리 가져오기
	public List<GoodsSuggestDto> selectGoodsBySuggest(GoodsDto goodsDto);

}