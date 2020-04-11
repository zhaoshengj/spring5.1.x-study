package com.zsj.study.IoC.config;

import com.zsj.study.IoC.DTO.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class LoginPostProcessor implements BeanPostProcessor {

	/**
	 *
	 * 初始化bean 前执行
	 *
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof Person){
			System.out.println("BeanPostProcessor---------------postProcessBeforeInitialization");
			((Person) bean).setOld(26);
		}
		return bean;
	}

	/**
	 *
	 * 初始化bean 后执行
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof Person){
			System.out.println( "BeanPostProcessor---------------postProcessAfterInitialization");
			((Person) bean).setName("new");
		}
		return bean;
	}
}
