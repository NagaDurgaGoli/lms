package com.cg.librarymanagement.lms.dtos;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
@Entity
@Table
public class BookOrder 
{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	Long orderid;
	public Long getOrderid() {
		return orderid;
	}
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="bookid")
	private Book book;
	int quantity;
	@CreationTimestamp
	Date orderDate;
	String orderStatus;
	public BookOrder()
	{
		
	}
	public BookOrder(int quantity,Book book, String orderStatus) 
	{
		super();
		this.quantity = quantity;
		this.book=book;
		this.orderStatus=orderStatus;
		this.orderDate = new Date();
	}
	
	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Book{");
		sb.append("id:").append(orderid).append(",");
		sb.append("book").append(book);
		sb.append("quantity:").append(quantity).append(",");
		sb.append("date:").append(orderDate).append(",");
		sb.append("status:").append(orderStatus).append(",");
		sb.append("}");
		return sb.toString();
}
}
