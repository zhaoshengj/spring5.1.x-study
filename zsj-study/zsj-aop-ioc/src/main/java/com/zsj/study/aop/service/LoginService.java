package com.zsj.study.aop.service;

import org.springframework.aop.framework.AopContext;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("login")
public class LoginService implements Login {

	public String login(String username){
		System.out.println(username + ".....loginService...");

		/*LoginService loginService = (LoginService) AopContext.currentProxy();
		loginService.echo(username);
*/
		return "success";
	}

	public void echo(String zsj){
		System.out.println("第二次代理");
	}

}
