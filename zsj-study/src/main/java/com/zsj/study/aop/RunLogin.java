package com.zsj.study.aop;


import com.zsj.study.aop.config.AppConfig;
import com.zsj.study.aop.service.LoginService;
import com.zsj.study.aop.service.UserService;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunLogin {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		UserService service = (UserService) applicationContext.getBean("login");
		service.login("zsj");
	}
}
