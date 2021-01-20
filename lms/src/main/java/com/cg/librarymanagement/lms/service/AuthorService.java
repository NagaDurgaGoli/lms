package com.cg.librarymanagement.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.librarymanagement.lms.dao.AuthorDao;
import com.cg.librarymanagement.lms.dtos.Author;
import com.cg.librarymanagement.lms.dtos.Book;
import com.cg.librarymanagement.lms.exception.AuthorNotFoundException;



@Service
public class AuthorService 
{
	// wiring one bean into another bean
	@Autowired
	private AuthorDao authorDao;
	
	public List<Author> getAllAuthors() 
	{
		System.out.println("Authors...");
		return authorDao.findAll();
	}
	
	public Author getAuthorById(Long id)  
	{
		System.out.println("Author");
			Optional<Author>optional = authorDao.findById(id);
       if(!optional.isPresent()) 
       {
    	   throw new AuthorNotFoundException("Author not found for id "+id);
       }
       else
    	   return optional.get();
	}
	
	public Author addAuthor(Author author) 
	{
		
		return authorDao.save(author);
	}
	
	public Author updateAuthor(Long id, Author author) 
	{
		System.out.println("Author updated.");
   
		Optional<Author> repAuth =authorDao.findById(id);
		
        if(!repAuth.isPresent())
        {
        	throw new AuthorNotFoundException("Author not found for with given id "+id);
            
		}
        else
        {
        	Author authorToBeUpdated = repAuth.get();
            authorToBeUpdated.setId(author.getId());
			authorToBeUpdated.setFirstName(author.getFirstName());
			authorToBeUpdated.setLastName(author.getLastName());
			authorToBeUpdated.setEmail(author.getEmail());
			authorToBeUpdated.setContactno(author.getContactno());
			authorToBeUpdated.setBook(author.getBook());
		     return   authorDao.save(authorToBeUpdated);
        }
	}
	public String removeAuthor(Long authorId) 
	{
		System.out.println("Author removed.");
			Optional<Author> optional = authorDao.findById(authorId);
			if(!optional.isPresent())
	        {
	        	throw new AuthorNotFoundException("Author not found for with given id "+authorId);
	        }
			else
		       authorDao.deleteById(authorId);
		       return "Author deleted Sucessfully";
	}
	
}
