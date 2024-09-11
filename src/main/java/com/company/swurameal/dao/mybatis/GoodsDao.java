package com.company.swurameal.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.company.swurameal.dto.GoodsDto;
import com.company.swurameal.dto.GoodsImgDto;

@Mapper
public interface GoodsDao {
	
	/*public GoodsDto selectByGoodsId(int goodsId);*/

	public List<GoodsDto> selectAllGoods();
    public List<GoodsImgDto> selectAllGoodsImages();
}