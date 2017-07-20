package com.atguigu.tx.component.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MultTransactionService {
	
	@Autowired
	private BookShopService bookShopService;
	
	@Transactional
	public void multiTransaction() {
		
		bookShopService.purchase("Jerry", "ISBN-003");
		
		bookShopService.updatePrice("ISBN-001", 3000);
		
	}

}
