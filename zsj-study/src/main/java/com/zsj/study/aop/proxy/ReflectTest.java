package com.zsj.study.aop.proxy;

import com.zsj.study.aop.proxy.JDK.DynamicAgent;

import java.lang.reflect.InvocationTargetException;

public class ReflectTest {

	public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
		//注意一定要返回接口，不能返回实现类否则会报错
		Fruit fruit = (Fruit) DynamicAgent.agent(Fruit.class, new Apple());
		fruit.show();
	}
}
