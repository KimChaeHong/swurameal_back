package com.company.swurameal.dao.mybatis;

import org.apache.ibatis.annotations.Mapper;

import com.company.swurameal.dto.GoodsDto;

@Mapper
public interface GoodsDao {
	public GoodsDto selectByGoodsId(int goodsId);
}