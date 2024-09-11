package com.company.swurameal.dao.mybatis;

import com.company.swurameal.dto.GoodsDto;


public interface CategoryDao {
	public GoodsDto selectCategory(int goodsId);

	/*public List<GoodsDto> getGoods(String korean);*/


}
