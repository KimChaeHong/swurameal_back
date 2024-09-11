package com.company.swurameal.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.company.swurameal.dto.GoodsDto;

@Mapper
public interface KoreanDao {
	public GoodsDto selectCtegory(int goodsId);
	
	public List<GoodsDto> getGoods(String korean);

}
