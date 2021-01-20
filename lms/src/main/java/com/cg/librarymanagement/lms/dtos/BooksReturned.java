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



@Entity
public class BooksReturned {
	@Id
	@GeneratedValue
	private Long returnid;
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="user_fk")
	private String username;
//
//	@OneToMany(targetEntity=Book.class,cascade=CascadeType.ALL)
//	@JoinColumn(name="brs_fk",referencedColumnName="returnid")
	private String bookName;
	//@NotNull(message="Date should not be null")
	//@Temporal(TemporalType.DATE)
	private Date returnedDate;
	private int delayed_Days;
	private int penalty;
	//@NotEmpty(message="Can't be empty yes/no")
	private String penalty_Status;
	public BooksReturned() {
		super();
	}
	
	public BooksReturned(Long returnid, String username, String bookName, Date returnedDate, int delayed_Days,
			int penalty, String penalty_Status) {
		super();
		this.returnid = returnid;
		this.username = username;
		this.bookName = bookName;
		this.returnedDate = returnedDate;
		this.delayed_Days = delayed_Days;
		this.penalty = penalty;
		this.penalty_Status = penalty_Status;
	}

	public BooksReturned(String username, String bookName, Date returnedDate, int delayed_Days, int penalty,
			String penalty_Status) {
		super();
		this.username = username;
		this.bookName = bookName;
		this.returnedDate = returnedDate;
		this.delayed_Days = delayed_Days;
		this.penalty = penalty;
		this.penalty_Status = penalty_Status;
	}
	

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Long getReturnid() {
		return returnid;
	}
	public void setReturnid(Long returnid) {
		this.returnid = returnid;
	}	
	public Date getReturnedDate() {
		return returnedDate;
	}
	
	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}
	public int getPenalty() {
		return penalty;
	}	
	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}
	
	public int getDelayed_Days() {
		return delayed_Days;
	}
	
	public void setDelayed_Days(int delayed_Days) {
		this.delayed_Days = delayed_Days;
	}
	
	
	
	public String getPenalty_Status() {
		return penalty_Status;
	}
	
	public void setPenalty_Status(String penalty_Status) {
		this.penalty_Status = penalty_Status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BooksReturned [returnid=");
		builder.append(returnid);
		builder.append(", username=");
		builder.append(username);
		builder.append(", bookName=");
		builder.append(bookName);
		builder.append(", returnedDate=");
		builder.append(returnedDate);
		builder.append(", delayed_Days=");
		builder.append(delayed_Days);
		builder.append(", penalty=");
		builder.append(penalty);
		builder.append(", penalty_Status=");
		builder.append(penalty_Status);
		builder.append("]");
		return builder.toString();
	}
	}

