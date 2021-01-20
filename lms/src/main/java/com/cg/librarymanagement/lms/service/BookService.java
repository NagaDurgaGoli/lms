package com.cg.librarymanagement.lms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.librarymanagement.lms.dao.BookDao;
import com.cg.librarymanagement.lms.dtos.Book;
import com.cg.librarymanagement.lms.exception.BookNotFoundException;




@Service
public class BookService {

	@Autowired
	private BookDao library;

	public List<Book> getAllbooks() {
		System.out.println("Books...");
		return library.findAll();
	}

	/*public Book getBookById(Long id) {
		System.out.println("Book");
		Book book= library.findById(id).get();
	
			if(book==null)
				throw new OrderNotFoundException("order not found");
			else
				return book;
		}*/
		public Book addBook(Book book) {
		System.out.println("Book added.");
		return library.save(book);
		

	}

	public Book updateBook(Long id, Book book)
	{
		System.out.println("Book updated.");
		

		Optional<Book> repBook = library.findById(id);
		if (!repBook.isPresent()) 
		{
			throw new BookNotFoundException("Book Not Found With the given id"+id);
		}

		else 
		{

			Book bookToBeUpdated = repBook.get();
			bookToBeUpdated.setTitle(book.getTitle());
			bookToBeUpdated.setSubject(book.getSubject());
			bookToBeUpdated.setAuthor(book.getAuthor());
			bookToBeUpdated.setPublisher(book.getPublisher());
			bookToBeUpdated.setPublishedYear(book.getPublishedYear());
			bookToBeUpdated.setIsbn_code(book.getIsbn_code());
			bookToBeUpdated.setQuantity(book.getQuantity());
			bookToBeUpdated.setShelf_details(book.getShelf_details());
			
			return library.save(bookToBeUpdated);
		}

    }
        public String removeBook(Long bookId)
        {
		System.out.println("Book removed.");

	
			Optional<Book>optional= library.findById(bookId);
		    if(!optional.isPresent()){
		        throw new BookNotFoundException("book not found for id="+bookId);
		    }
		    else
		    library.deleteById(bookId);
		    return "Book deleted Sucessfully";
		    }
		    
         public List<Book> searchBooksBySubject(String subject)
        {
        
        	List<Book> book=new ArrayList<Book>();
    		library.findAll().forEach(book1->book.add(book1));
    		List<Book> genreBasedMovies=new ArrayList<Book>();
    		for(Book m:book)
    		{
    			if(m.getSubject().equals(subject))
    				genreBasedMovies.add(m);	
    		}
    		return genreBasedMovies;
        	

    	}
       
        
          
}


