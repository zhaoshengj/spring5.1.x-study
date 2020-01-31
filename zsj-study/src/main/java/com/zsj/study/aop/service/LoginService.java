package com.zsj.study.aop.service;

import org.springframework.stereotype.Service;

@Service("login")
public class LoginService {

	public String login(String username){
		System.out.println(username + ".....loginService...");
		return "success";
	}

}
