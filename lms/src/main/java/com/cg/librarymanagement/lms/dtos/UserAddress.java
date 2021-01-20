package com.cg.librarymanagement.lms.dtos;

/** 
 AUTHOR : Prathyusha Narsupalli
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserAddress {
	@Id
	@GeneratedValue
	private int addressId;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private int pincode;

	
	public UserAddress() {
		
	}


	public UserAddress(String address1, String address2, String city, String state, int pincode) {
		super();
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
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
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Address{");
		sb.append("AddressId:").append(addressId).append(",");
		sb.append("Address1:").append(address1).append(",");
		sb.append("Address2:").append(address2).append(",");
		sb.append("City:").append(city).append(",");
		sb.append("State:").append(state).append(",");
		sb.append("PinCode:").append(pincode).append("");
		sb.append("}");
		
		return sb.toString();
	}
	
	
}

