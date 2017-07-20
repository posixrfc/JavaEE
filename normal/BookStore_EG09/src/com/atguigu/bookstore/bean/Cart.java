package com.atguigu.bookstore.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 封装购物车信息的类
 * 
 * @author lilichao
 * 
 */
public class Cart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 用来保存购物项的集合
	 */
	private Map<String, CartItem> map = new HashMap<String, CartItem>();

	/**
	 * 购物车中商品的总数
	 */
	//private int totalCount;

	/**
	 * 购物车中商品的总金额
	 */
	//private double totalAmount;
	
	/**
	 * 获取购物项的列表
	 * @return
	 */
	public List<CartItem> getCartItems(){
		
		//获取所有的CartItem的集合
		Collection<CartItem> collection = this.map.values();
		//将集合转换成一个List
		List<CartItem> cartItems = new ArrayList<CartItem>(collection);
		
		return cartItems;
		
	}
	
	/**
	 * 更新购物项的数量
	 * @param bookId
	 * @param countStr
	 */
	public void updateCount(String bookId , String countStr){
		
		//获取要更新的购物项
		CartItem cartItem = this.map.get(bookId);
		//将String强转为int
		int count = Integer.parseInt(countStr);
		//设置数量
		cartItem.setCount(count);
		
	}
	
	
	/**
	 * 向购物车中添加一本图书
	 * @param book
	 */
	public void addBook2Cart(Book book){
		
		//获取map中cartItem
		CartItem cartItem = this.map.get(book.getId()+"");
		//如果CartItem为空代表当前购物车中没有这本图书
		if(cartItem == null){
			//创建一个CartItem
			cartItem = new CartItem();
			//将图书设置进CartItem
			cartItem.setBook(book);
			//设置图书的数量
			cartItem.setCount(1);
			//将cartItem放入到Map中
			this.map.put(book.getId()+"", cartItem);
		}else{
			//购物车中已经包含这本书，让数量+1
			int count = cartItem.getCount();
			cartItem.setCount(count+1);
		}
		
	}
	
	/**
	 * 删除购物项
	 * @param bookId
	 */
	public void delCartItem(String bookId){
		
		this.map.remove(bookId);
		
	}
	
	
	/**
	 * 清空购物车
	 */
	public void clear(){
		this.map.clear();
	}

	public Map<String, CartItem> getMap() {
		return map;
	}

	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}

	/**
	 * 计算商品的总数量
	 * @return
	 */
	public int getTotalCount() {
		
		int totalCount = 0;
		
		//获取所有的购物项
		Collection<CartItem> cartItems = map.values();
		//遍历所有的购物项
		for (CartItem cartItem : cartItems) {
			totalCount += cartItem.getCount();
		}
		
		return totalCount;
	}


	/**
	 * 计算商品的总金额
	 * @return
	 */
	public double getTotalAmount() {
		
		//double totalAmount = 0;
		BigDecimal totalAmount = new BigDecimal("0");
		
		//获取所有的购物项
		Collection<CartItem> cartItems = map.values();
		//遍历所有的购物项
		for (CartItem cartItem : cartItems) {
			totalAmount = totalAmount.add(new BigDecimal(cartItem.getAmount()+""));
		}
		
		return totalAmount.doubleValue();
	}


	public Cart() {
	}

}
