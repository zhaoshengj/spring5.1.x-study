package com.zsj.study.IoC.config;


import com.zsj.study.IoC.DTO.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("com.zsj.study.IoC")
@Configuration
public class IoCConfig {


	@Bean(initMethod = "initMethod",destroyMethod="destroyMethod")
	public Person person(){
		Person person = new Person();
		person.setName("zsj");
		person.setOld(20);
		return person;
	}
}
