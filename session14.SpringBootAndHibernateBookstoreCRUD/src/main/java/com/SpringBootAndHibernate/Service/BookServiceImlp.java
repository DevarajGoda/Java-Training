package com.SpringBootAndHibernate.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.naming.ldap.PagedResultsResponseControl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import com.SpringBootAndHibernate.Entity.Book;
import com.SpringBootAndHibernate.Exception.BookNotFoundException;
import com.SpringBootAndHibernate.Repository.BookRepository;

@Service
public class BookServiceImlp implements BookService {

	@Autowired
	private BookRepository bookRepo;
	
	@Override
	public Book saveBook(Book book) {
		Book books = bookRepo.save(book);
		return books;
	}

	@Override
	public Book getById(Long bookId) {
		Optional<Book> opt = bookRepo.findById(bookId);
		 Book book = opt.orElseThrow(()-> 
		 new BookNotFoundException("Book with this Id is Not Exist"));
		return book;
	}

	@Override
	public Book getByName(String bookName) {
		Book book = bookRepo.findByBookName(bookName);
		if(book == null) {
			new BookNotFoundException("Book with this Name is Not Present");
		}
		return book;
	}

	@Override
	public Book updateBook(Long bookId, Book book) {
		Book existBook = bookRepo.getById(bookId);
		if(existBook != null) {
			existBook.setBookName(book.getBookName());
			existBook.setBookAuth(book.getBookAuth());
			existBook.setBookCost(book.getBookCost());
			existBook.setActive(book.isActive());
			return bookRepo.save(existBook);
		}
		return null;
	}

	@Override
	public List<Book> getAllBooks(Integer page, Integer size)  {
		PageRequest pageable = PageRequest.of(page, size);
        Page<Book> bookpage = this.bookRepo.findAll(pageable);
        List<Book> content = bookpage.getContent();
		if(content == null) {
			new BookNotFoundException("Books are Not Avable");
		}
		return content;
	}

	@Override
	public List<Book> getActiveBooks() {
		List<Book> books = bookRepo.findAll();
		 List<Book> activeBooks = new ArrayList<>();
		 
	        for (Book book : books) {
	            if (book.isActive()==true) {
	                activeBooks.add(book);
	            }
	        }
	        return activeBooks;
	    }

	@Override
	public void deleteBook(Long bookId) {
		Book book = new Book();
        book.setBookId(bookId);
		try {
	        if (bookId != null)
	        	bookRepo.deleteById(bookId);
	    } catch (Exception e) {
	    	new BookNotFoundException("Book Id is Not Avable");
	    }
	}

	 

}
