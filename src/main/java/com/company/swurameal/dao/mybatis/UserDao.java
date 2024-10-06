package com.company.swurameal.dao.mybatis;

import org.apache.ibatis.annotations.Mapper;

import com.company.swurameal.dto.UserDto;

@Mapper
public interface UserDao {
	
	//회원 가입
	public int insert(UserDto user);
	
	//회원 정보 가져오기
	public UserDto selectByUserId(String userId);

	//회원 정보 수정
	public int updateByUserId(UserDto user);
	
	//회원 정보 비활성화
	public int deactivateUserById(String userId);

}
