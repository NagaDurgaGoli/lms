package com.cg.librarymanagement.lms.controller;

import java.util.List;

import javax.validation.Valid;
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

import com.cg.librarymanagement.lms.dtos.Author;
import com.cg.librarymanagement.lms.service.AuthorService;


@Controller
//Helps to map user request URL to the specific controller class/method it can be placed at both class level and method level
@Validated
@RequestMapping("/author")
public class AuthorController 
{
	 //Logger log = LoggerFactory.getLogger(AuthorController.class);
	 
		@Autowired
		private AuthorService authorService;

		@GetMapping(value = {"/" })
		public @ResponseBody List<Author> getAllAuthors() 
		{ 
			List<Author> author = authorService.getAllAuthors();
			return author;
		}
		
		@GetMapping("/{id}")
		public @ResponseBody  Author getAuthorById(@PathVariable Long id) 
		{
			return authorService.getAuthorById(id);
		}
		
		@PostMapping("/")
		public @ResponseBody Author addAuthor(@RequestBody Author author) 
		{
			return authorService.addAuthor(author);
		}
		
		@PutMapping("/{id}")
		public @ResponseBody Author updateAuthor(@PathVariable Long id,@RequestBody Author author) 
		{
			return authorService.updateAuthor(id,author);
		}

		@DeleteMapping("/{id}")
		public @ResponseBody String removeAuthor(@PathVariable Long id) 
		{
			return authorService.removeAuthor(id);
		}
}
