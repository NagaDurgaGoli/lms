package com.cg.librarymanagement.lms.dtos;



import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity
@Table
public class BooksIssued {
	@Id
	@GeneratedValue
	private Long issueId;
	//@NotNull(message="Date should not be null")
	//@Temporal(TemporalType.DATE)
	private Date issueDate;

	private int quantity;
	//@NotNull(message="Date should not be null")
	//@Temporal(TemporalType.DATE)
	private Date dueDate;
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="user_fk")
	private String username;
	
	//@OneToMany(mappedBy="booksIssued",cascade=CascadeType.ALL,fetch= FetchType.LAZY)
//	@OneToMany(targetEntity=Book.class,cascade=CascadeType.ALL)
//	@JoinColumn(name="bis_fk",referencedColumnName="issueId")
	private String  bookname;

	
	public BooksIssued() {
		super();
	}


	
	public BooksIssued(Long issueId, Date issueDate, int quantity, Date dueDate, String username, String bookname) {
		super();
		this.issueId = issueId;
		this.issueDate = issueDate;
		this.quantity = quantity;
		this.dueDate = dueDate;
		this.username = username;
		this.bookname = bookname;
	}




	public BooksIssued(Date issueDate, int quantity, Date dueDate, String username, String bookname) {
		super();
		this.issueDate = issueDate;
		this.quantity = quantity;
		this.dueDate = dueDate;
		this.username = username;
		this.bookname = bookname;
	}



	public Long getIssueId() {
		return issueId;
	}

	
	public void setIssueId(Long issueId) {
		this.issueId = issueId;
	}

	
	public Date getIssueDate() {
		return issueDate;
	}

	
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BooksIssued [issueId=");
		builder.append(issueId);
		builder.append(", issueDate=");
		builder.append(issueDate);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", dueDate=");
		builder.append(dueDate);
		builder.append(", username=");
		builder.append(username);
		builder.append(", bookname=");
		builder.append(bookname);
		builder.append("]");
		return builder.toString();
	}	
	}
