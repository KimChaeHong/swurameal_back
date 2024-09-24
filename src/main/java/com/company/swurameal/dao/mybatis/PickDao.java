package com.company.swurameal.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.company.swurameal.dto.PickDto;

@Mapper
public interface PickDao {

	// 사용자 ID로 찜에 담긴 모든 상품 조회 (여러 상품이 있을 수 있으므로 List로 반환)
	public List<PickDto> selectPickByUserId(String userId);
	
	//사용자 ID와 찜ID로 장바구니의 특정 상품 조회
	public PickDto selectGoodsInPick(String userId, int goodsId);

	//상품 ID로 찜한 상품 삭제
	public int delete(int goodsId);

	//찜 등록
	public void insert(PickDto pick);

}
