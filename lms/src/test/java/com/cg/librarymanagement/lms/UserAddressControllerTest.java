package com.cg.librarymanagement.lms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.librarymanagement.lms.controller.UserAddressController;
import com.cg.librarymanagement.lms.dtos.UserAddress;
import com.cg.librarymanagement.lms.exception.UserNotFoundException;
import com.cg.librarymanagement.lms.service.UserAddressService;


@ExtendWith(MockitoExtension.class)
class UserAddressControllerTest {

	@Mock
	UserAddressService addressservice;

	@InjectMocks
	UserAddressController addresscontroller;

	@Test
	public void registerUserTest() 
	{
		UserAddress address=new UserAddress("Alwal","lalagooda","hyderabad","Telangana",500010);
		Mockito.when(addressservice.addUserAddress(address)).thenReturn("User address added succesfully");
		assertEquals("User address added succesfully",addresscontroller.addUserAddress(address));
	}

	@Test
	public void ViewAllUserAddressTest() 
	{
		List<UserAddress> l=new ArrayList<UserAddress>();
		Mockito.when(addressservice.viewUserAddressList()).thenReturn(l);
		assertEquals(l,addresscontroller.viewAllAddress());
	}

	@Test
	public void updateUserAddressTest() throws UserNotFoundException 
	{
		UserAddress address=new UserAddress("Alwal","lalagooda","hyderabad","Telangana",500010);
		int addressid=12;
		Mockito.when(addressservice.updateAddress(address)).thenReturn(address);
		assertEquals(address,addresscontroller.updateAddress(addressid,address));
	}
	
	@Test
	public void viewAddressByUserId() throws UserNotFoundException 
	{
		UserAddress address=new UserAddress();
		int userid=12;
		Mockito.when(addressservice.viewAddressByUserId(userid)).thenReturn(address);
		assertEquals(address,addresscontroller.viewAddressByUserId(userid));
	}
	
	
}
