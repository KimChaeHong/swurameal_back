package com.company.swurameal.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.company.swurameal.dao.mybatis.UserDao;
import com.company.swurameal.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	public enum JoinResult{
		SUCCESS,
		FAIL_DUPLICATED_USERID
		
}
	public enum LoginResult{
		SUCCESS,
		FAIL_USERID,
		FAIL_USERPASSSWORD,
		FAIL_ENABLED
		
	}
	
	@Resource
	private UserDao userDao;
	
	public JoinResult join(UserDto user) {
		boolean exist = isUserid(user.getUserId());
		if (exist) {
			return JoinResult.FAIL_DUPLICATED_USERID;
		}
		
		userDao.insert(user);
		return JoinResult.SUCCESS;
	
	}

	private boolean isUserid(String userId) {
		UserDto user = userDao.selectByUserId(userId);
		if (user == null) {
			return false;
		}else {
			return true;
		}
	}
	
	
}
