package com.cg.librarymanagement.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.librarymanagement.lms.dao.PublisherDao;
import com.cg.librarymanagement.lms.dtos.Publishers;
import com.cg.librarymanagement.lms.exception.PublisherNotFoundException;




@Service
public class PublisherService {
	@Autowired
	private PublisherDao publisherdao;
	
	public Publishers addPublisher(Publishers publisher) {
		System.out.println("publishers added.");
		return publisherdao.save(publisher);
	}

	public Publishers updatePublisherDetails(int publisherId,Publishers publisher) {
		System.out.println("publishers updated.");
		try
		{
		Optional<Publishers> repPublisher = publisherdao.findById(publisherId);
		if(!repPublisher.isPresent())
		{
			throw new PublisherNotFoundException("publisher not found with id"+publisherId);
		}
		else {
			Publishers publisherToBeUpdated = repPublisher.get();
			publisherToBeUpdated.setPublisherName(publisher.getPublisherName());
			publisherToBeUpdated.setContactno(publisher.getContactno());
			publisherToBeUpdated.setEmail(publisher.getEmail());
			publisherToBeUpdated.setAddress1(publisher.getAddress1());
			publisherToBeUpdated.setAddress2(publisher.getAddress2());
			publisherToBeUpdated.setCity(publisher.getCity());
			publisherToBeUpdated.setState(publisher.getState());
			publisherToBeUpdated.setPincode(publisher.getPincode());
			return publisherdao.save(publisherToBeUpdated);

		}
		}
      catch(PublisherNotFoundException e)
      {
    	  System.err.println(e);
      }
		return null;
	}
	
	//wrong code have to change
	public Publishers removePublisher(int publisherId) 
{
		System.out.println("Publishers");
		try {
		Optional<Publishers> optional = publisherdao.findById(publisherId);
		if (!optional.isPresent()) {
			throw new PublisherNotFoundException("No publishers present with id "+publisherId);
		}
		else
			return optional.get();
		}
		catch(PublisherNotFoundException e)
		{
		//publisherdao.deleteById(publisherId);
		//return "publisherid deleted Sucessfully";
			System.err.println(e);
	}
	return null;
}
	public List<Publishers> viewPublishersList() {
		System.out.println("publishers...");
		return publisherdao.findAll();
	}
	
	
	public Publishers viewPublisherById(int publisherId) {
		System.out.println("Publishers");
		
			Optional<Publishers> optional = publisherdao.findById(publisherId);
			if(!optional.isPresent()) {
				throw new PublisherNotFoundException("no publishers present for id="+publisherId);
			}
	
			else
				return optional.get();
	
		
          
        }

	}