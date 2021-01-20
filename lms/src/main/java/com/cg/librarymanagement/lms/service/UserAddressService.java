package com.cg.librarymanagement.lms.service;

/** 
 AUTHOR : Prathyusha Narsupalli
 */

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.librarymanagement.lms.dao.UserAddressDao;
import com.cg.librarymanagement.lms.dao.UserDao;
import com.cg.librarymanagement.lms.dtos.*;
import com.cg.librarymanagement.lms.exception.AddressNotFoundException;
import com.cg.librarymanagement.lms.exception.UserNotFoundException;

@Service
public class UserAddressService {
	
	@Autowired
	private UserAddressDao userAddressDao;
	@Autowired
	private UserDao userDao;
	
	public String addUserAddress(UserAddress address) {
		userAddressDao.save(address);
		return "User Address Succesfully Added ";
	}
	
	public List<UserAddress> viewUserAddressList() {
		return userAddressDao.findAll();
	}
	
	public UserAddress updateAddress(UserAddress address) {

		Optional<UserAddress> repaddress = userAddressDao.findById(address.getAddressId());

		if (repaddress.isPresent()) {

			UserAddress updatedAddress = repaddress.get();
			updatedAddress.setAddress1(address.getAddress1());
			updatedAddress.setAddress2(address.getAddress2());
			updatedAddress.setCity(address.getCity());
			updatedAddress.setState(address.getState());
			updatedAddress.setPincode(address.getPincode());

			return userAddressDao.save(updatedAddress);

		}
		else {
			throw new AddressNotFoundException("No such Address present for updatation");
		}
	}
	
	public UserAddress viewAddressByUserId(int userid){
		System.out.println(userid);
		Optional<User> user =userDao.findById(userid);
		if (user.isPresent()) {
			User u=user.get();
			return u.getAddress();
		}
		else {
			throw new UserNotFoundException("No User present with this user id "+userid);
		}
	}
}
