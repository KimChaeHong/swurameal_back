package com.company.swurameal.dao;

import org.apache.ibatis.annotations.Mapper;

import com.company.swurameal.dto.GoodsDto;

@Mapper
public class KoreanDao {
	public int insert(GoodsDto goods);
	public GoodsDto selectByMid(String goodsName);
}
