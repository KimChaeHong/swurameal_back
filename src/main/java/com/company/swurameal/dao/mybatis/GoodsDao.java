package com.company.swurameal.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.company.swurameal.dto.GoodsDto;
import com.company.swurameal.dto.GoodsImgDto;


@Mapper
public interface GoodsDao {

	public List<GoodsDto> selectAllGoods();
	public GoodsImgDto selectAttachByGoodsID(int goodsId);
	public GoodsDto selectByGoodsID(int goodsId);

}