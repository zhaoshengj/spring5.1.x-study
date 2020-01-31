package com.zsj.study.mybatis;

import com.alibaba.fastjson.JSON;
import com.zsj.study.mybatis.config.Config;
import com.zsj.study.mybatis.dao.UserMapper;
import com.zsj.study.mybatis.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class RunMabatis {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(Config.class);

		UserService userService = applicationContext.getBean(UserService.class);
		List<Map<String, Object>> query = userService.query();

		SqlSessionFactory factory = null;
		try {
			SqlSessionFactoryBean bean = applicationContext.getBean(SqlSessionFactoryBean.class);
			factory = bean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		SqlSession sqlSession = factory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		query = mapper.query();


		System.out.println(JSON.toJSONString(query));
	}
}
