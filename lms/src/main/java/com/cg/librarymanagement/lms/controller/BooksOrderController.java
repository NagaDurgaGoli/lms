package com.cg.librarymanagement.lms.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.cg.librarymanagement.lms.dtos.BookOrder;
import com.cg.librarymanagement.lms.service.BookOrderService;


@Controller
@RequestMapping("/booksorder")
public class BooksOrderController {
Logger log = LoggerFactory.getLogger(BooksOrderController.class);
	
@Autowired
private BookOrderService bookOrderService;
	
@GetMapping(value = {"/" })
public @ResponseBody List<BookOrder> getLibraryBooks() 
{ 
	List<BookOrder> booksOrder = bookOrderService.getAllbooksOrder();
	return booksOrder;
}

@GetMapping("/{orderid}")
public @ResponseBody  BookOrder getBookOrderById(@PathVariable Long orderid) 
{
	return bookOrderService.getBookOrderById(orderid);
}

@PostMapping("/")
public @ResponseBody BookOrder addBookOrder(@RequestBody BookOrder bookorder) 
{
	return bookOrderService.addBookOrder(bookorder);
}

@PutMapping("/{orderid}")
public @ResponseBody BookOrder updateBookOrder(@PathVariable Long orderid,@RequestBody BookOrder bookOrder) 
{
	return bookOrderService.updateBookOrder(orderid, bookOrder);
}

@DeleteMapping("/{orderid}")
public @ResponseBody String removeBook(@PathVariable Long orderid) 
{
	return bookOrderService.removeBookOrder(orderid);
}
}
