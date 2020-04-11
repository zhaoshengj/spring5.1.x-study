package com.zsj.study.IoC;

import com.zsj.study.IoC.DTO.Person;
import com.zsj.study.IoC.config.IoCConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IoCRun {
	public static void main(String[] args) {

		/**
		 * 完整的生命周期
		 */
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IoCConfig.class);

		Person person = (Person) context.getBean("person");
		person.display();

		System.out.println("方法调用完成，容器开始关闭....");
        // 关闭容器
		context.registerShutdownHook();

	}
}
