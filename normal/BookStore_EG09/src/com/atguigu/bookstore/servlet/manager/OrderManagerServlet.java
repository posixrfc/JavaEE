package com.atguigu.bookstore.servlet.manager;

import com.atguigu.bookstore.bean.Order;
import com.atguigu.bookstore.service.OrderService;
import com.atguigu.bookstore.service.impl.OrderServiceImpl;
import com.atguigu.bookstore.servlet.BaseServlet;
import com.atguigu.bookstore.utils.WEBUtils;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理管理端订单业务的Servlet
 * @author lilichao
 *
 */
public class OrderManagerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private OrderService orderService = new OrderServiceImpl();
	
	
	/**
	 * 发货的方法
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void sendBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取orderId
		String orderId = request.getParameter("orderId");
		//指定一个state
		String state = "1";
		//调用Service修该订单状态
		orderService.updateOrderState(orderId, state);
		//回到订单页面
		WEBUtils.goBack(request, response);
		
	}

	/**
	 * 返回所有的订单列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void orderList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取所有的订单列表
		List<Order> list = orderService.getOrderList();
		//将list放入到request
		request.setAttribute("list", list);
		//转发到order_manager.jsp
		request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
	}


}
