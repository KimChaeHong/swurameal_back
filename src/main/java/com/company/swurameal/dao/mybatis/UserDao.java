package com.company.swurameal.dao.mybatis;

import org.apache.ibatis.annotations.Mapper;

import com.company.swurameal.dto.UserDto;

@Mapper
public interface UserDao {
	
	public int insert(UserDto user);
	public UserDto selectByUserId(String userId);
	public boolean existsByUserId(String userId);
}
