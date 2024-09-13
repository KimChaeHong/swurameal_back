package com.company.swurameal.dao.mybatis;

import java.util.List;
<<<<<<< HEAD

import org.apache.ibatis.annotations.Mapper;
=======
>>>>>>> branch 'master' of https://github.com/KimChaeHong/swurameal_back.git

import org.apache.ibatis.annotations.Mapper;
import com.company.swurameal.dto.GoodsDto;
import com.company.swurameal.dto.GoodsImgDto;
<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/KimChaeHong/swurameal_back.git

@Mapper
public interface GoodsDao {
<<<<<<< HEAD
	public List<GoodsDto> selectKoreanGoods();

	public GoodsImgDto selectAttachByGoodsId(int goodsId);
=======
	
	//상품 하나 가져오기
	/*public GoodsDto selectByGoodsID(int goodsId);*/

	//상품 이미지 가져오기
	public GoodsImgDto selectAttachByGoodsID(int goodsId);
	
	//전체 상품 가져오기
	public List<GoodsDto> selectAllGoods();
	
	//상품 카테고리 가져오기
	public List<GoodsDto> selectGoodsByCategory(String category);

>>>>>>> branch 'master' of https://github.com/KimChaeHong/swurameal_back.git

}