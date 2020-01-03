package com.zsj.study.main;


import com.zsj.study.service.LoginService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunLogin {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		((ClassPathXmlApplicationContext) context).refresh();
		LoginService service = (LoginService) context.getBean("login");
		service.login("zsj");
	}
}
