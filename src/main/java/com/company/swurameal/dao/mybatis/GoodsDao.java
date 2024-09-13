package com.company.swurameal.dao.mybatis;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import com.company.swurameal.dto.GoodsDto;
import com.company.swurameal.dto.GoodsImgDto;


@Mapper
public interface GoodsDao {

	
	//상품 하나 가져오기
	/*public GoodsDto selectByGoodsID(int goodsId);*/

	//상품 이미지 가져오기
	public GoodsImgDto selectAttachByGoodsID(int goodsId);
	
	//전체 상품 가져오기
	public List<GoodsDto> selectAllGoods();
	
	//상품 카테고리 가져오기
	public List<GoodsDto> selectGoodsByCategory(String category);


}