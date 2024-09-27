package com.company.swurameal.dao.mybatis;

import org.apache.ibatis.annotations.Mapper;

import com.company.swurameal.dto.GoodsImgDto;

@Mapper
public interface GoodsImgDao {
	
	//상품 이미지 등록하기
	public int insert(GoodsImgDto goodsImg);
	
	//상품 이미지 수정하기
	public int update(GoodsImgDto goodsImg);

}
