package com.cg.librarymanagement.lms.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.librarymanagement.lms.dao.BookOrderDao;
import com.cg.librarymanagement.lms.dtos.BookOrder;
import com.cg.librarymanagement.lms.exception.OrderNotFoundException;



@Service
public class BookOrderService {
	@Autowired
	private BookOrderDao library;

	public List<BookOrder> getAllbooksOrder() {
		System.out.println("Books...");
		return library.findAll();
	}

	public BookOrder getBookOrderById(Long orderid) 
	{
	System.out.println("Book");
    
	Optional<BookOrder>optional= library.findById(orderid);
    if(!optional.isPresent()){
        throw new OrderNotFoundException("order not found for id="+orderid);
    }
    else
    return optional.get();
   }
   public BookOrder addBookOrder(BookOrder bookOrder)
	{
		System.out.println("Book added.");
		return library.save(bookOrder);
	}

public BookOrder updateBookOrder(Long orderid, BookOrder bookOrder) 
{
		System.out.println("Book updated.");
		
		Optional<BookOrder> repBookOrder = library.findById(orderid);
		if(!repBookOrder.isPresent()) {
			throw new OrderNotFoundException("order not found for id="+orderid);
}
      
else 
{
            BookOrder orderToBeUpdated = repBookOrder.get();
			orderToBeUpdated.setQuantity(bookOrder.getQuantity());
			orderToBeUpdated.setBook(bookOrder.getBook());
			orderToBeUpdated.setOrderDate(bookOrder.getOrderDate());
			orderToBeUpdated.setOrderStatus(bookOrder.getOrderStatus());
			return library.save(orderToBeUpdated);

}
}
	
public String removeBookOrder(Long orderid) 
{
		System.out.println("Book removed.");
		

			Optional<BookOrder>optional= library.findById(orderid);
		    if(!optional.isPresent()){
		        throw new OrderNotFoundException("order not found for id="+orderid);
		    }
		    else
		    library.deleteById(orderid);
		    return "Book deleted Sucessfully";
		  
        
}
}
