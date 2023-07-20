package com.SpringBootAndHibernate.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SpringBootAndHibernate.Entity.Book;

@Service
public interface BookService {

	/**
	 * Add a new book.
       Update an existing book.
       Delete a book.
       Retrieve a list of all books.
       Retrieve details of a specific book.
       
	   Fetch with book name
       Fetch with pagination for all records
       fetch active books
	 */
	
	Book saveBook(Book book);
	Book getById(Long bookId);
	Book getByName(String bookName);
	Book updateBook(Long bookId, Book book);
	List<Book> getAllBooks(Integer page,Integer size);
	List<Book> getActiveBooks();
	void deleteBook(Long bookId);
}
