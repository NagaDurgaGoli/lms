package com.cg.librarymanagement.lms.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.librarymanagement.lms.dtos.Book;
import com.cg.librarymanagement.lms.service.BookService;

import org.springframework.validation.annotation.Validated;

import java.util.List;

import javax.validation.Valid;

@Controller
@Validated
@RequestMapping("/books")
public class BookController{

	
	@Autowired
	private BookService bookService;
	


@GetMapping(value = {"/" })
public @ResponseBody List<Book> getLibraryBooks() 
{ 
	
	List<Book> books = bookService.getAllbooks();
	return books;
}
@GetMapping("/{subject}")
public @ResponseBody List<Book> getBookBySubject(@PathVariable("subject") String subject)
{
	return bookService.searchBooksBySubject(subject);
}


@PostMapping("/")
public @ResponseBody Book addBook(@Valid @RequestBody  Book book) 
{
	
		
	return bookService.addBook(book);
}
@PutMapping("/{id}")
public @ResponseBody Book updateBook(@PathVariable Long id,@RequestBody Book book) 
{
	return bookService.updateBook(id,book);
}
@DeleteMapping("/{id}")
public @ResponseBody String removeBook(@PathVariable Long id) 
{
	return bookService.removeBook(id);
}

}

