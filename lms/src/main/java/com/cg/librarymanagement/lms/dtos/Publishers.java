package com.cg.librarymanagement.lms.dtos;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="publisher_details")
public class Publishers {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int publisherId;
	

	private String publisherName;
	

	private String contactno;
	

	private String email;

	private String address1;
	

	private String address2;
	

	private String city;
	

	private String state;
	

	private String pincode;
	
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public Publishers() {
		super();
	}
	public Publishers(String publisherName, String contactno, String email, String address1, String address2,
			String city, String state, String pincode) {
		super();
		this.publisherName = publisherName;
		this.contactno = contactno;
		this.email = email;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	public Publishers(int publisherId, String publisherName, String contactno, String email, String address1,
			String address2, String city, String state, String pincode) {
		super();
		this.publisherId = publisherId;
		this.publisherName = publisherName;
		this.contactno = contactno;
		this.email = email;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Publishers [publisherId=");
		builder.append(publisherId);
		builder.append(", publisherName=");
		builder.append(publisherName);
		builder.append(", contactno=");
		builder.append(contactno);
		builder.append(", email=");
		builder.append(email);
		builder.append(", address1=");
		builder.append(address1);
		builder.append(", address2=");
		builder.append(address2);
		builder.append(", city=");
		builder.append(city);
		builder.append(", state=");
		builder.append(state);
		builder.append(", pincode=");
		builder.append(pincode);
		builder.append("]");
		return builder.toString();
	}

}