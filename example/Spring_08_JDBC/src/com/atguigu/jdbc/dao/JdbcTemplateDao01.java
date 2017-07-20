package com.atguigu.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcTemplateDao01 {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void save() {
		System.out.println(jdbcTemplate);
	}

}
