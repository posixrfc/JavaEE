package junit.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.atguigu.bookstore.dao.OrderItemDao;
import com.atguigu.bookstore.dao.impl.BookDaoImpl;
import com.atguigu.bookstore.dao.impl.OrderItemDaoImpl;

public class TestBaseDao {
	
	//BaseDao<Book> dao = new BaseDao<Book>();
	OrderItemDao dao = new OrderItemDaoImpl();
	BookDaoImpl bookDaoImpl = new BookDaoImpl();

	@Test
	public void testMap(){
		dao.getOrderItemByOrderId("14391765593734");
	}
	
	@Test
	public void testGetMap() {
		
		String sql = "SELECT * FROM "
				+ "bs_order_item o , bs_book b WHERE o.book_id = b.id";
		List<Map<String, Object>> list = bookDaoImpl.getMapList(sql);
		
		//System.out.println(list);
		
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}

}
