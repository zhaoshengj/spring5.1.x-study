package com.zsj.study.aop;

import com.zsj.study.aop.config.AppConfig;
import com.zsj.study.aop.service.LoginService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunLogin {

	public static void main(String[] args) {

		//ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("");
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		//UserService service = (UserService) applicationContext.getBean("&login");
		LoginService service = (LoginService) applicationContext.getBean("login");
		service.login("zsj");
	}


}
