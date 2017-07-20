package junit.test;

import org.junit.Test;

import com.atguigu.bookstore.bean.Page;

public class TestPage {

	@Test
	public void testPage() {
		
		Page page = new Page();
		
		page.setPageSize(5);
		page.setTotalRecord(100);
		page.setPageNumber(2);
		
		//System.out.println(page.getTotalPage());
		
		System.out.println(page.getIndex());
	}

}
