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

	// 중복 체크를 위한 메서드
    public boolean isUserid(String userId) {
        return userDao.existsByUserId(userId); // userId가 존재하는지 확인하는 메서드
    }
	
	public LoginResult login(UserDto user) {
		UserDto dbuser = userDao.selectByUserId(user.getUserId());
		
		//1. 로그인
		if(dbuser == null) {
			return LoginResult.FAIL_USERID;
		}
		
		//2.아이디 존재 안함
		if(!dbuser.isUserEnable()) {
			return LoginResult.FAIL_ENABLED;
		}
		
		//3. 비밀번호 틀림
		if(!dbuser.getUserPw().equals(user.getUserPw())) {
			return LoginResult.FAIL_USERPASSSWORD;
		}
		
		return LoginResult.SUCCESS;
	}

	 
}
