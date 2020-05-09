package com.zsj.study.IoC.DTO;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;

public class Person implements BeanNameAware, BeanFactoryAware, BeanClassLoaderAware, InitializingBean, DisposableBean {

	private String name;

	private Integer old;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("属性注入");
		this.name = name;
	}

	public Integer getOld() {
		return old;
	}

	public void setOld(Integer old) {
		this.old = old;
	}

	public Person() {
		System.out.println("构造函数调用...");
	}

	public void display(){
		System.out.println("方法调用...");
	}

	@PostConstruct
	public void postConstruct(){
		System.out.println("@PostConstruct 方法调用...");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean afterPropertiesSet 被调用...");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean destroy 被调动...");
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("BeanClassLoaderAware 被调用...");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

		System.out.println("BeanFactoryAware 被调用...");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("BeanNameAware 被调用...");
	}

	public void initMethod(){
		System.out.println("init-method");
	}

	public void destroyMethod(){
		System.out.println("destroy-method");
	}





	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", old=" + old +
				'}';
	}


}
