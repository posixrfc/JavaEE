package com.atguigu.ioc.component.dao;

import org.springframework.stereotype.Repository;

import com.atguigu.ioc.component.base.BaseRepository;
import com.atguigu.ioc.component.entity.Book;

@Repository
public class BookDao extends BaseRepository<Book>{
	
	@Override
	public void save() {
		System.out.println("saved by book dao...");
	}

}
