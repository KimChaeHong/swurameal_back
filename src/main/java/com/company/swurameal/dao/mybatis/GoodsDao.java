package com.company.swurameal.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.company.swurameal.dto.GoodsDto;
import com.company.swurameal.dto.GoodsImgDto;
import com.company.swurameal.dto.GoodsSuggestDto;


@Mapper
public interface GoodsDao {

	//상품 하나 가져오기
	public GoodsDto selectByGoodsID(int goodsId);

	//상품 이미지 가져오기
	public GoodsImgDto selectAttachByGoodsImgId(int goodsImgId);
	
	//상품 이미지 imgRole에 따라 가져오기
	public GoodsImgDto selectAttachByImgRole(GoodsImgDto goodsImgDto);

	//전체 상품 가져오기
	public List<GoodsDto> selectAllGoods();
	
	//동일 카테고리 상품 가져오기
	public List<GoodsDto> selectGoodsByCategory(String category);
	
	//동일 서브 카테고리 상품 가져오기
	public List<GoodsDto> selectGoodsBySubCategory(String subcategory);
	
	//상품 추천 카테고리 가져오기
	public List<GoodsSuggestDto> selectGoodsBySuggest(GoodsDto goodsDto);

	//알콜 추천 카테고리 가져오기
	public List<GoodsSuggestDto> selectAlcoholBySuggest(GoodsDto goodsDto);
	
	//상품 등록하기
	public int insert(GoodsDto goods);
	
	//상품 수정하기
	public int update(GoodsDto goods);

}