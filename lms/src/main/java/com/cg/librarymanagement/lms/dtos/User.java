package com.cg.librarymanagement.lms.dtos;

/** 
 AUTHOR : Prathyusha Narsupalli
 */

import java.util.Date;
import javax.persistence.*;



@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userid;
	

	private String password;
	

	private String firstName;
	
	private String lastName;
	

	private String mobileno;
	

	private String email;
	

	private Date date_of_birth;
	private Date subscription_date;
	private Date sub_expire_date;
	private String subscription_status;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Address_fk")
	private UserAddress address;
	
	public User() {
		
	}


	public User(String password, String firstName, String lastName, String mobileno, String email, Date date_of_birth,
			Date subscription_date, Date sub_expire_date, String subscription_status,UserAddress address) {
		super();
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileno = mobileno;
		this.email = email;
		this.date_of_birth = date_of_birth;
		this.subscription_date = subscription_date;
		this.sub_expire_date = sub_expire_date;
		this.subscription_status = subscription_status;
		this.address=address;
	}

	public Integer getUserid() {
		return userid;
	}
	
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
	
	public String getMobileno() {
		return mobileno;
	}
	
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	
	public Date getSubscription_date() {
		return subscription_date;
	}
	
	public void setSubscription_date(Date subscription_date) {
		this.subscription_date = subscription_date;
	}
	
	public Date getSub_expire_date() {
		return sub_expire_date;
	}
	
	public void setSub_expire_date(Date sub_expire_date) {
		this.sub_expire_date = sub_expire_date;
	}
	
	public String getSubscription_status() {
		return subscription_status;
	}
	
	public void setSubscription_status(String subscription_status) {
		this.subscription_status = subscription_status;
	}

	public UserAddress getAddress() {
		return address;
	}

	public void setAddress(UserAddress address) {
		this.address = address;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("User{");
		sb.append("id:").append(userid).append(",");
		sb.append("Password:").append(password).append(",");
		sb.append("FirstName:").append(firstName).append(",");
		sb.append("LastName:").append(lastName).append(",");
		sb.append("MobileNo:").append(mobileno).append(",");
		sb.append("Email:").append(email).append(",");
		sb.append("Date of birth:").append(date_of_birth).append(",");
		sb.append("subscription date:").append(subscription_date).append(",");
		sb.append("subscription expirey date:").append(sub_expire_date).append(",");
		sb.append("subscription status:").append(subscription_status).append(",");
		sb.append("Address:").append(address).append("");
		sb.append("}");
		
		return sb.toString();
	}
	
	
}
