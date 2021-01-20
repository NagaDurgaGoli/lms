package com.cg.librarymanagement.lms.controller;


/** 
 AUTHOR : Prathyusha Narsupalli
 */

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.librarymanagement.lms.dtos.User;
import com.cg.librarymanagement.lms.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/register")
	public String registerUser(@Valid @RequestBody User user){

		return userService.registerUser(user);
	}

	@DeleteMapping("/Delete/{id}")
	public @ResponseBody String DeleteUser(@PathVariable int id) 
	{

		return userService.removeUser(id);

	}

	@PutMapping("/updateDetails/{id}")
	public @ResponseBody String updateUser(@PathVariable int id, @Valid @RequestBody User user) 
	{
		user.setUserid(id);
		return userService.updateUser(user);

	}

	@GetMapping("/")
	public @ResponseBody List<User> viewAllUsers() 
	{ 
		List<User> users = userService.viewAllusers();
		return users;
	}
	
	@PutMapping("/CancelSubscription/{id}")
	public @ResponseBody String cancelSubscription(@PathVariable int id)
	{ 

		return userService.cancelSubscription(id);

	}
	
	@GetMapping("/LoginValidation/{username}/{password}")
	public @ResponseBody String loginValidate(@PathVariable String username,@PathVariable String password) {
		
		return userService.loginValidate(username, password);
	}
}