package com.atguigu.bookstore.bean;

/**
 * 封装订单项的信息
 * 
 * @author lilichao
 * 
 */
public class OrderItem {

	private Integer id;

	/**
	 * 图书的数量
	 */
	private int count;

	/**
	 * 图书的总金额
	 */
	private double amount;

	/**
	 * 订单项对应的图书的ID
	 */
	private int bookId;

	/**
	 * 订单项所属的订单的id
	 */
	private String orderId;
	
	/**
	 * 当前订单项的图书信息
	 */
	private Book book;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public OrderItem(Integer id, int count, double amount, int bookId,
			String orderId) {
		super();
		this.id = id;
		this.count = count;
		this.amount = amount;
		this.bookId = bookId;
		this.orderId = orderId;
	}

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", count=" + count + ", amount="
				+ amount + ", bookId=" + bookId + ", orderId=" + orderId + "]";
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
