package com.zsj.study.aop.aspectdemo;


import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NotVeryUsefulAspect {


	@Pointcut("execution(* com.zsj.study.aop.service.*.*(..))")
	public void businessService() {}

	@Before("businessService()")
	public void befer(){
		System.out.println("----------befer-----------");

	}

	@After("businessService()")
	public void after(){
		System.out.println("----------after-----------");
	}


	@AfterReturning("businessService()")
	public void end(){
		System.out.println("----------afterReturning-----------");
	}


}
