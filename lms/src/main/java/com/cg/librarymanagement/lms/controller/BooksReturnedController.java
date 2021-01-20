package com.cg.librarymanagement.lms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cg.librarymanagement.lms.dtos.BooksReturned;
import com.cg.librarymanagement.lms.exception.BookNotFoundException;
import com.cg.librarymanagement.lms.service.BooksReturnedService;


//@CrossOrigin(origins="http://localhost:3000")
@Controller
@RequestMapping("/booksreturned")
public class BooksReturnedController {
	
	
	@Autowired
	private BooksReturnedService  booksReturnedService;
	
	//creating post mapping that post the BooksReturned detail in the database
	@PostMapping("/")
	public @ResponseBody BooksReturned addreturnBooks(@Valid @RequestBody BooksReturned returned) {
		return booksReturnedService.addreturnBooks(returned);
	}
	//creating put mapping that updates the BooksReturned detail
	@PutMapping("/{returnid}")
	public @ResponseBody BooksReturned updateBooksReturned(@PathVariable Long returnid,@RequestBody BooksReturned booksReturned) {
		return booksReturnedService.updateBooksReturned(returnid, booksReturned);
	}
	//creating a get mapping that retrieves the detail of a all books
	@GetMapping(value = {"/" })
	public @ResponseBody List<BooksReturned> viewReturnedBooksList(){
		return booksReturnedService.viewReturnedBooksList();
	}
	@GetMapping("/{issueId}")
	public @ResponseBody  BooksReturned getBooksReturnedById(@PathVariable Long issueId) 
	{
		return booksReturnedService.getBooksReturnedById(issueId);
	}
	@DeleteMapping("/{issueId}")
	public @ResponseBody String removeBook(@PathVariable Long issueId) throws BookNotFoundException 
	{
		return booksReturnedService.removeBooksReturnedById(issueId);
	}
}


