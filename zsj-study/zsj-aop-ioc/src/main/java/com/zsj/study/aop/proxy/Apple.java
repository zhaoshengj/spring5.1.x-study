package com.zsj.study.aop.proxy;

public class Apple implements Fruit {
	@Override
	public void show() {
		System.out.println("<<<<show method is invoked");
	}
}
