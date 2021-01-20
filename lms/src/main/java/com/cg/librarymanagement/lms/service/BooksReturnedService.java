package com.cg.librarymanagement.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.librarymanagement.lms.dao.BooksReturnedDao;
import com.cg.librarymanagement.lms.dtos.BooksReturned;
import com.cg.librarymanagement.lms.exception.BookNotFoundException;



@Service
public class BooksReturnedService {
	@Autowired
	private BooksReturnedDao booksReturnedDao;
	
	public BooksReturned addreturnBooks(BooksReturned returned) {
		return booksReturnedDao.save(returned);
		
	}
	public BooksReturned updateBooksReturned(Long id,BooksReturned booksReturned)
	{
		Optional<BooksReturned > repBooksReturned = booksReturnedDao.findById(id);

		if (!repBooksReturned.isPresent()) {
			throw new BookNotFoundException("Book not found for id "+id);}else{

			BooksReturned returnedToBeUpdated = repBooksReturned.get();
			
			returnedToBeUpdated.setBookName(booksReturned.getBookName());
			returnedToBeUpdated.setUsername(booksReturned.getUsername());
			returnedToBeUpdated.setReturnedDate(booksReturned.getReturnedDate());
			returnedToBeUpdated.setDelayed_Days(booksReturned.getDelayed_Days());
			returnedToBeUpdated.setPenalty(booksReturned.getPenalty());
			returnedToBeUpdated.setPenalty_Status(booksReturned.getPenalty_Status());
			return booksReturnedDao.save(returnedToBeUpdated);
		}
	}
	public List<BooksReturned> viewReturnedBooksList(){
		return booksReturnedDao.findAll();
	}
	public BooksReturned getBooksReturnedById(Long returnid)
	{
		System.out.println("BooksReturned");
		Optional<BooksReturned>optional = booksReturnedDao.findById(returnid);
		if(!optional.isPresent()) {
			throw new BookNotFoundException("Book not found for id "+returnid);
	       }
		else {
			return optional.get();
		}
	}
	public String removeBooksReturnedById(Long returnid) {
		{
		        Optional<BooksReturned> optional = booksReturnedDao.findById(returnid);
		       if(!optional.isPresent())
               {
			           throw new BookNotFoundException("Book not found for id "+returnid);
                }

		       booksReturnedDao.deleteById(returnid);
		return "Book deleted Sucessfully";
		}  
}
	
	
}