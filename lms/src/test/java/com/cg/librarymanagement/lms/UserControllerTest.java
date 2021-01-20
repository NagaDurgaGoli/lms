package com.cg.librarymanagement.lms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.librarymanagement.lms.controller.UserController;
import com.cg.librarymanagement.lms.dtos.User;
import com.cg.librarymanagement.lms.exception.UserNotFoundException;
import com.cg.librarymanagement.lms.service.UserService;


@ExtendWith(MockitoExtension.class)
class UserControllerTest {

	@Mock
    UserService userservice;
	
	@InjectMocks
	UserController usercontroller;
	
    @Test
	public void registerUserTest() 
          {
    	 User user=new User("1234","prathyusha","N","1234567891","abc@gmail.com",new Date(),new Date(),new Date(),"No",null);
		 Mockito.when(userservice.registerUser(user)).thenReturn("User registration succesfull");
		 assertEquals("User registration succesfull",usercontroller.registerUser(user));
		  }
    
    @Test
	public void updateUserTest() throws UserNotFoundException 
          {
    	 User user=new User("1234","prathyusha","N","1234567891","abc@gmail.com",new Date(),new Date(),new Date(),"No",null);
    	 int id=13;
		 Mockito.when(userservice.updateUser(user)).thenReturn("User details updated succesfull");
		 assertEquals("User details updated succesfull",usercontroller.updateUser(id,user));
		  }
    
    @Test
	public void deleterUserTest() 
          {
    	 int id=14;
		 Mockito.when(userservice.removeUser(id)).thenReturn("User details deleted succesfully");
		 assertEquals("User details deleted succesfully",usercontroller.DeleteUser(id));
		  }
    
    @Test
	public void UserLoginTest() 
          {
    	 String username="prathyusha";
    	 String password="1234";
		 Mockito.when(userservice.loginValidate(username, password)).thenReturn("User login validation succesfully");
		 assertEquals("User login validation succesfully",usercontroller.loginValidate(username, password));
		  }
    
    @Test
	public void ViewUsersTest() 
          {
    	 List<User> l=new ArrayList<User>();
		 Mockito.when(userservice.viewAllusers()).thenReturn(l);
		 assertEquals(l,usercontroller.viewAllUsers());
		  }
    
    
    @Test
	public void UserCancelSubscriptionTest() 
          {
    	 int id=13;
		 Mockito.when(userservice.cancelSubscription(id)).thenReturn("User subscription cancelled succesfully");
		 assertEquals("User subscription cancelled succesfully",usercontroller.cancelSubscription(id));
		  }

}
