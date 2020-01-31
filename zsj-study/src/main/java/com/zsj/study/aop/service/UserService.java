package com.zsj.study.aop.service;

import org.springframework.stereotype.Service;

@Service("user")
public class UserService {

	public String login(String username){
		System.out.println(username + ".....userService...");
		return "userService";
	}
}
