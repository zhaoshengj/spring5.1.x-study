package com.zsj.study.mybatis.config;


import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@ComponentScan("com.zsj.study.mybatis")
@Configuration
@MapperScan("com.zsj.study.mybatis.dao")
public class Config {

  @Bean
  public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws Exception {
	SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
	factoryBean.setDataSource(dataSource);
	return factoryBean;
  }

 @Bean
 public DataSource dataSource(){
	 DriverManagerDataSource dataSource = new DriverManagerDataSource();
	 dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	 dataSource.setUsername("root");
	 dataSource.setPassword("admin123");
	 dataSource.setUrl("jdbc:mysql://120.79.4.13:3306/wms_test?useSSL=false&useUnicode=true&characterEncoding=UTF-8");
	 return  dataSource;

 }

}
