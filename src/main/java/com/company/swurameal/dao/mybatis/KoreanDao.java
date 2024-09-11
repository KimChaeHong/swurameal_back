package com.company.swurameal.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.company.swurameal.dto.GoodsDto;

@Mapper
public class KoreanDao {

	public List<GoodsDto> getGoods(String korean) {
		
		return null;
	}
/*	public int insert(GoodsDto goods);
	public GoodsDto selectByMid(String goodsName);*/
	

}
