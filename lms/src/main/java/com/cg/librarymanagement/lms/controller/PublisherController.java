package com.cg.librarymanagement.lms.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.librarymanagement.lms.dtos.Publishers;
import com.cg.librarymanagement.lms.service.PublisherService;






@Controller
@Validated
@RequestMapping("/publishers")
public class PublisherController {
Logger log = LoggerFactory.getLogger(PublisherController.class);
	
	@Autowired
	private PublisherService publisherservice;
	@PostMapping("/")
	public @ResponseBody Publishers addPublisher(@RequestBody @Valid Publishers publisher) 
	{
		return publisherservice.addPublisher(publisher);
	}
	@PutMapping("/{publisherId}")
	public @ResponseBody Publishers updatePublisherDetails(@PathVariable int publisherId,@RequestBody Publishers publisher) 
	{
		
		return publisherservice.updatePublisherDetails(publisherId,publisher);
	}

	@DeleteMapping("/{publisherId}")
	public @ResponseBody Publishers removePublisher(@PathVariable int publisherId) 
	{
		return publisherservice.removePublisher(publisherId);
	}
	@GetMapping(value = {"/" })
	public @ResponseBody List<Publishers> viewPublishersList() 
	{ 
		
		List<Publishers> publishers = publisherservice.viewPublishersList();
		
		return publishers;
	}
	@GetMapping("/{id}")
	public @ResponseBody Publishers viewPublisherById(@PathVariable int id) 
	{
		return publisherservice.viewPublisherById(id);
	}


}