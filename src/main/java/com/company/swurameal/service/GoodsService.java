package com.company.swurameal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.swurameal.dao.mybatis.GoodsDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GoodsService (int ) {
	@Autowired
	private GoodsDao goodsDao;

}
