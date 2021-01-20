package com.cg.librarymanagement.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.librarymanagement.lms.dao.BooksIssuedDao;
import com.cg.librarymanagement.lms.dtos.BooksIssued;
import com.cg.librarymanagement.lms.exception.BookNotFoundException;



@Service
public class BooksIssuedService {
	@Autowired
	private BooksIssuedDao booksIssuedDao;
	

	public List<BooksIssued> getAllbooksIssued() {
		System.out.println("Books...");
		return booksIssuedDao.findAll();
	}

	public BooksIssued getBooksIssuedById(Long issueId)
	{
		System.out.println("BooksIssued");
		Optional<BooksIssued>optional = booksIssuedDao.findById(issueId);
		if(!optional.isPresent()) {
			throw new BookNotFoundException("Book not found for id "+issueId);
	       }
		else {
			return optional.get();
		}

	}
   public BooksIssued addBooksIssued(BooksIssued booksIssued)
	{
		System.out.println("Book added.");
		return booksIssuedDao.save(booksIssued);
	}

	public BooksIssued updateBooksIssued(Long issueId, BooksIssued  booksIssued)  {
		System.out.println("Book updated.");

		Optional<BooksIssued > repBooksIssued = booksIssuedDao.findById(issueId);

		if (!repBooksIssued.isPresent()) {
			throw new BookNotFoundException("Book not found for id "+issueId);
		}else {

			BooksIssued issuedToBeUpdated = repBooksIssued .get();
			
			issuedToBeUpdated.setQuantity(booksIssued.getQuantity());
			issuedToBeUpdated.setUsername(booksIssued.getUsername());
			issuedToBeUpdated.setBookname(booksIssued.getBookname());
			issuedToBeUpdated.setIssueDate(booksIssued.getIssueDate());
			issuedToBeUpdated.setDueDate(booksIssued.getDueDate());
			return booksIssuedDao.save(issuedToBeUpdated);
		}
 }
	public String removeBoksIssuedById(Long issueId) {
		{
		        Optional<BooksIssued> optional = booksIssuedDao.findById(issueId);
		       if(!optional.isPresent())
               {
			           throw new BookNotFoundException("Book not found for id "+issueId);
                }

		booksIssuedDao.deleteById(issueId);
		return "Book deleted Sucessfully";
		}  
}
}
