package com.cg.librarymanagement.lms.dtos;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="author")
public class Author 
{
	@Id
	
	private long authorid;
	

	@Column(name="first_name")
	private String firstName;
	

	
	@Column(name="last_name")
	private String lastName;
	

	
	@Column(name="email")
	private String email;


	@Column(name = "contact_no",unique=true)
	private String contactno;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="book_id")
	private Book book;
	
	public Author() 
	{
		
	}

	public Author( String firstName, String lastName, String email, String contactno, Book book)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactno = contactno;
		this.book = book;
	}

	public long getId() {
		return authorid;
	}

	public void setId(long id) {
		this.authorid = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Author [id=");
		builder.append(authorid);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", contactno=");
		builder.append(contactno);
		builder.append(", books=");
		builder.append(book);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
	

}
