package com.company.swurameal.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.company.swurameal.dto.CartDto;

@Mapper
public interface CartDao {
		
	 List<CartDto> selectByGoodsId(String userId);
}

