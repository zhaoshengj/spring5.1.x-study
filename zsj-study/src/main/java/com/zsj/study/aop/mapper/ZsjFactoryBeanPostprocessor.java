package com.zsj.study.aop.mapper;

import com.zsj.study.aop.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class ZsjFactoryBeanPostprocessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

		GenericBeanDefinition indexService = (GenericBeanDefinition) beanFactory.getBeanDefinition("login");
		indexService.setBeanClass(UserService.class);

	}
}
