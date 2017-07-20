package com.atguigu.bookstore.servlet.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bookstore.bean.Book;
import com.atguigu.bookstore.bean.Cart;
import com.atguigu.bookstore.bean.CartItem;
import com.atguigu.bookstore.service.BookService;
import com.atguigu.bookstore.service.impl.BookServiceImpl;
import com.atguigu.bookstore.servlet.BaseServlet;
import com.atguigu.bookstore.utils.WEBUtils;
import com.google.gson.Gson;

/**
 * 处理购物车相关功能的Servlet
 */
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private BookService bookService = new BookServiceImpl();
	
	/**
	 * 修改购物项数量
	 */
	protected void updateCount(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//获取购物车
		Cart cart = WEBUtils.getCart(request);
		//获取bookId以及count
		String bookId = request.getParameter("bookId");
		String countStr = request.getParameter("count");
		//修改数量
		cart.updateCount(bookId, countStr);
		
		//获取需要返回页面的信息三个数据1.amount书小计金额 2. totalCount商品的总数 3. totalAmount商品的总金额
		CartItem cartItem = cart.getMap().get(bookId);
		//图书的小计金额
		double amount = cartItem.getAmount();
		//商品总数量
		int totalCount = cart.getTotalCount();
		//商品的总金额
		double totalAmount = cart.getTotalAmount();
		//将三个数据转换成JSON
		Map<String, Object> map = new HashMap<String, Object>();
		//如果在map直接存储double型数据，那么页面上，将会将小数点以后的0全都去掉，为了保住0，我们自己将double转换为字符串
		map.put("amount", amount+"");
		map.put("totalCount", totalCount);
		map.put("totalAmount", totalAmount+"");
		
		Gson gson = new Gson();
		String str = gson.toJson(map);
		
		//作为响应发送
		response.getWriter().print(str);
		
	}
	
	/**
	 * 清空购物车
	 */
	protected void clear(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获取购物车
		Cart cart = WEBUtils.getCart(request);
		//清空购物车
		cart.clear();
		//回首页
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	
	}
	

	/**
	 * 删除购物项的方法
	 */
	protected void delCartItem(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//获取要删除的图书的ID
		String bookId = request.getParameter("bookId");
		//获取购物车
		Cart cart = WEBUtils.getCart(request);
		//删除购物项
		cart.delCartItem(bookId);
		//回到购物车页面
		WEBUtils.goBack(request, response);
		
	}
       
	/**
	 * 向购物车中添加图书
	 */
	protected void add2Cart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取图书的ID
		String bookId = request.getParameter("bookId");
		//根据id获取book对象
		Book book = bookService.getBookById(bookId);
		//获取购物车对象
		Cart cart = WEBUtils.getCart(request);
		
		//将图书添加进Cart中
		cart.addBook2Cart(book);
		
		//获取图书的title
		String  title = book.getTitle();
		
		//获取购物车中商品的数量
		int count = cart.getTotalCount();
		
		//将title和count转换成JSON对象
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("title", title);
		map.put("count", count);
		//使用GSON将map转换为一个JSON字符串
		Gson gson = new Gson();
		String str = gson.toJson(map);
		
		//将字符串作为响应发送
		//response.getWriter().print()就是设置响应体
		//AJAX读取的响应内容，实际上就是响应报文的响应体
		response.getWriter().print(str);
	}

}
