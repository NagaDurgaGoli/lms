package com.cg.librarymanagement.lms.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.librarymanagement.lms.dtos.Feedback;
import com.cg.librarymanagement.lms.service.FeedbackService;




@Controller
@Validated
@RequestMapping("/feedback")
public class FeedbackController {
Logger log = LoggerFactory.getLogger(FeedbackController.class);
	
	@Autowired
	private FeedbackService feedbackservice;
	
	
	@PostMapping("/")
	public @ResponseBody  Feedback writeFeedback(@RequestBody @Valid Feedback feedback)
	{
		return feedbackservice.writeFeedback(feedback);
	}
	
	@PutMapping("/{id}")
	public @ResponseBody Feedback updateFeedback(@PathVariable int id,@RequestBody Feedback feedback) 
	{
		
		return feedbackservice.updateFeedback(id,feedback);
	}
	
	@GetMapping(value = {"/" })
	public @ResponseBody  List<Feedback> viewFeedbackList() 
	{ 
		
		List<Feedback> feedback =feedbackservice.viewFeedbackList();
		
		return feedback;
	}
	
	@GetMapping("/{userid}")
	public @ResponseBody  Feedback viewFeedBackByUser(@PathVariable int userid) 
	{
		return feedbackservice.viewFeedBackByUser(userid);
	}

}