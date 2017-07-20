package com.atguigu.struts2.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService {
	
	@Autowired
	private BookDao bookDao;

	public String getMessage() {
		return bookDao.getMessage();
	}

}
