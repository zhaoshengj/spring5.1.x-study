package com.zsj.study.mybatis.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {


	@Select("select * from user ")
	public List<Map<String,Object>> query();
}
