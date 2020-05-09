package com.zsj.study.mybatis.service;

import com.zsj.study.mybatis.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public List<Map<String, Object>> query(){

		/**
		 * JDK 动态代理
		 */
		List<Map<String, Object>> query = userMapper.query();

		return query;
	}

}
