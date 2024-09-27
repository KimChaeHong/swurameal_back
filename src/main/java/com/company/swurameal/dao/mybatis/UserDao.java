package com.company.swurameal.dao.mybatis;

import org.apache.ibatis.annotations.Mapper;

import com.company.swurameal.dto.UserDto;

@Mapper
public interface UserDao {
	
	public int insert(UserDto user);
	public UserDto selectByUserId(String userId);
<<<<<<< HEAD
	
=======
	public boolean existsByUserId(String userId);
	//회원 정보 수정
	public int updateByUserId(UserDto user);
	//회원 정보 비활성화
	public int deactivateUserById(String userId);

>>>>>>> branch 'master' of https://github.com/KimChaeHong/swurameal_back
}
