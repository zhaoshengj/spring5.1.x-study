package com.zsj.study.aop.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("com.zsj.study.aop")
@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
}
