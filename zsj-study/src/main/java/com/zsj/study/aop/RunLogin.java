package com.zsj.study.aop;


import com.zsj.study.aop.config.AppConfig;
import com.zsj.study.aop.service.LoginService;
import com.zsj.study.aop.service.UserService;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.locks.ReentrantLock;

public class RunLogin {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("");
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		//UserService service = (UserService) applicationContext.getBean("&login");
		UserService service = (UserService) applicationContext.getBean("login");
		service.login("zsj");
	}
}
