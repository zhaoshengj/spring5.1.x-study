package com.zsj.study.aop.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan("com.zsj.study.aop")
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = false,exposeProxy = true)
public class AppConfig {
}
