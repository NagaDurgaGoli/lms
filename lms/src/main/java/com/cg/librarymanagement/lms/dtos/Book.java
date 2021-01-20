package com.cg.librarymanagement.lms.dtos;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;





@Validated
@Entity
@Table
public class Book{
	
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	Long id;

	public Long getId() {
		return id;
	}
	
    String title;
	String subject;
	
	String author;
	
	String publisher;
	int publishedYear;
	
	
	String isbn_code;
	int quantity;
	String shelf_details;
    public Book() 
    {
		
	}
public Book(String title, String subject, String author, String publisher, int publishedYear,
			String isbn_code, int quantity, String shelf_details) {
		super();
		this.title = title;
		this.subject = subject;
		this.author = author;
		this.publisher = publisher;
		this.publishedYear = publishedYear;
		this.isbn_code = isbn_code;
		this.quantity = quantity;
		this.shelf_details = shelf_details;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public int getPublishedYear() {
		return publishedYear;
	}


	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}


	public String getIsbn_code() {
		return isbn_code;
	}


	public void setIsbn_code(String isbn_code) {
		this.isbn_code = isbn_code;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getShelf_details() {
		return shelf_details;
	}


	public void setShelf_details(String shelf_details) {
		this.shelf_details = shelf_details;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Book{");
		sb.append("id:").append(id).append(",");
		sb.append("title:").append(title).append(",");
		sb.append("subject:").append(subject).append(",");
		sb.append("publisher").append(publisher).append(",");
		sb.append("publishYear:").append(publishedYear).append(",");
		sb.append("isbn_code:").append(isbn_code).append(",");
		sb.append("quantity:").append(quantity).append("");
		sb.append("shelf_shelf:").append(shelf_details);
		sb.append("}");
		
		return sb.toString();
	}
	
	
	
	
	
	
	
	


}
	
