package com.cg.librarymanagement.lms.service;

/** 
 AUTHOR : Prathyusha Narsupalli
 */

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.librarymanagement.lms.exception.UserNotFoundException;
import com.cg.librarymanagement.lms.dao.UserDao;
import com.cg.librarymanagement.lms.dtos.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public List<User> viewAllusers() {
		return userDao.findAll();
	}

	public String removeUser(int userId){

		Optional<User> repUser = userDao.findById(userId);
		if (repUser.isPresent()==false) {
			throw new UserNotFoundException("No user present with id "+userId);
		}
		userDao.deleteById(userId);
		return "User Details succesfully deleted";
	}

	public String updateUser(User user) {

		Optional<User> repUser = userDao.findById(user.getUserid());

		if (repUser.isPresent()) {

			User userToBeUpdated = repUser.get();
			userToBeUpdated.setFirstName(user.getFirstName());
			userToBeUpdated.setLastName(user.getLastName());
			userToBeUpdated.setPassword(user.getPassword());
			userToBeUpdated.setEmail(user.getEmail());
			userToBeUpdated.setMobileno(user.getMobileno());
			userToBeUpdated.setDate_of_birth(user.getDate_of_birth());
			userToBeUpdated.setSub_expire_date(user.getSub_expire_date());
			userToBeUpdated.setSubscription_date(user.getSubscription_date());
			userToBeUpdated.setSubscription_status(user.getSubscription_status());

			userDao.save(userToBeUpdated);
		}
		else {
			throw new UserNotFoundException("No user present with id "+user.getUserid());
		}

		return "User Details updated succesfully";
	}

	public String registerUser(User user) {
		userDao.save(user);
		return "User Registration successfull ";
	}

	public String cancelSubscription(int userid){
		Optional<User> repUser = userDao.findById(userid);
		if (repUser.isPresent()) {
			User userToBeUpdated = repUser.get();
			userToBeUpdated.setSubscription_status("NO");
			userDao.save(userToBeUpdated);
		}
		else {
			throw new UserNotFoundException("No user present with id "+userid);
		}
		return "Subscription Cancelled succesfully";
	}

	public String loginValidate(String username,String password) {
		List<User> l1= userDao.findAll();
		for(User u:l1) {
			if(u.getFirstName().equals(username) && u.getPassword().equals(password)) {
				return "Login validation Succesfull";
			}
			else if(u.getFirstName().equals(username) && u.getPassword().equals(password)==false) {
				return "Incorrect Password.Login validation unsucessfull";
			}
		}
		throw new UserNotFoundException("No user present with username "+username);
	}

}
