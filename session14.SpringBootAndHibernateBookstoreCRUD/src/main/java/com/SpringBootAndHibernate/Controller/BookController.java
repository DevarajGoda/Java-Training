package com.SpringBootAndHibernate.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootAndHibernate.Entity.Book;
import com.SpringBootAndHibernate.Service.BookService;

@RestController
@RequestMapping("/book/api")
public class BookController {

	@Autowired
	private BookService bookService;
	
	//save
	@PostMapping("/createBook")
	public ResponseEntity<Book> saveBook(@RequestBody Book book){
		Book books = bookService.saveBook(book);
		return new ResponseEntity<>(books,HttpStatus.CREATED) ;
	}
	
	//delete
	@DeleteMapping("/deleteBook/{bookId}")
	public ResponseEntity<Void> removeBook(@PathVariable Long bookId){
		bookService.deleteBook(bookId);
		return ResponseEntity.ok().build();
	}
	
	//update
	@PutMapping("/updatBook/{bookId}")
	public ResponseEntity<Book> updateBook(@PathVariable Long bookId, @RequestBody Book book){
		Book books = bookService.updateBook(bookId, book);
		return new ResponseEntity<>(books,HttpStatus.OK);
		
	}
	
	//fetch all with pa
	@GetMapping("/allBooks")
	public ResponseEntity<List<Book>> fetchAllBooks(@Validated @RequestParam(name = "page", defaultValue = "0") Integer page,
			@Validated @RequestParam(name = "size", defaultValue = "10") Integer size){
		List<Book> list = bookService.getAllBooks(page, size);
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	//fatch by id
	@GetMapping("/getByBookId/{bookId}")
	public ResponseEntity<Book> fetchByBookId(@PathVariable Long bookId){
		Book book = bookService.getById(bookId);
		return new ResponseEntity<>(book,HttpStatus.OK);
		
	}
	
	//fetch by name
	@GetMapping("/getByBookName/{bookName}")
	public ResponseEntity<Book> getByBookName (@PathVariable String bookName){
		Book book = bookService.getByName(bookName);
		return new ResponseEntity<>(book,HttpStatus.OK);
	}
	
	//fetch All Active
	@GetMapping("/getAllActiveBooks")
	public ResponseEntity<List<Book>> getAllActiveBooks(){
		List<Book> book = bookService.getActiveBooks();
		return new ResponseEntity<>(book,HttpStatus.OK);
	}
}
