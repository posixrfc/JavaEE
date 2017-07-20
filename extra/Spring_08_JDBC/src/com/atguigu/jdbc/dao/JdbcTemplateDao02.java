package com.atguigu.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcTemplateDao02 extends JdbcDaoSupport{
	
	@Autowired
	public void setMyJdbcTemplate(JdbcTemplate jdbcTemplate) {
		super.setJdbcTemplate(jdbcTemplate);
	}
	
	public void save() {
		JdbcTemplate jdbcTemplate2 = getJdbcTemplate();
		System.out.println(jdbcTemplate2);
	}

}
