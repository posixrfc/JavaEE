package com.atguigu.bookstore.servlet.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.bookstore.bean.Cart;
import com.atguigu.bookstore.bean.Order;
import com.atguigu.bookstore.bean.User;
import com.atguigu.bookstore.service.OrderService;
import com.atguigu.bookstore.service.impl.OrderServiceImpl;
import com.atguigu.bookstore.servlet.BaseServlet;
import com.atguigu.bookstore.utils.WEBUtils;

/**
 * 处理客户端订单业务的Servlet
 * @author lilichao
 *
 */
public class OrderClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private OrderService orderService = new OrderServiceImpl();
	
	/**
	 * takeBook
	 */
	protected void takeBook(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		//获取订单号
		String orderId = request.getParameter("orderId");
		//设置一个state
		String state = "2";
		//调用Service
		orderService.updateOrderState(orderId, state);
		//回到订单页面
		WEBUtils.goBack(request, response);
		
	}
	
	/**
	 * 返回当前用户的订单列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void orderList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		//获取Session中loginUser
		User user = (User) session.getAttribute("loginUser");
		//登录调用service查询订单列表
		List<Order> list = orderService.getOrderListByUserId(user.getId()+"");
		//将list放入到request域中
		request.setAttribute("list", list);
		//转发到order.jsp
		request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
		
		
	}
	
       
	/**
	 * 结账
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		//判断用户是否登录
		User user = (User) session.getAttribute("loginUser");
		//获取购物车对象
		Cart cart = WEBUtils.getCart(request);
		//调用Service生成订单
		String orderId = orderService.createOrder(cart, user);
		//将订单号设置到request域中
		request.setAttribute("orderId", orderId);
		//转发到pages/cart/checkout.jsp
		request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request, response);
		
	}


}
