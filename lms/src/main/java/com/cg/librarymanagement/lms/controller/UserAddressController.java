package com.cg.librarymanagement.lms.controller;


/** 
 AUTHOR : Prathyusha Narsupalli
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.librarymanagement.lms.dtos.UserAddress;
import com.cg.librarymanagement.lms.service.UserAddressService;


@RestController
@RequestMapping("/useraddress")
public class UserAddressController {

	@Autowired
	private UserAddressService addressService;
	
	@PostMapping(value = "/addAddress")
	public String addUserAddress(@RequestBody UserAddress address){
		
		return addressService.addUserAddress(address);
	}
	
	@GetMapping("/")
	public @ResponseBody List<UserAddress> viewAllAddress() 
	{ 
		List<UserAddress> address = addressService.viewUserAddressList();
		return address;
	}
	
	@PutMapping("/updateAddress/{id}")
	public @ResponseBody UserAddress updateAddress(@PathVariable int id,@RequestBody UserAddress address)
	{
		address.setAddressId(id);
		return addressService.updateAddress(address);
	}
	
	@GetMapping("/{userid}")
	public @ResponseBody UserAddress viewAddressByUserId(@PathVariable int userid)
	{ 
		UserAddress address = addressService.viewAddressByUserId(userid);
		return address;
	}

}
