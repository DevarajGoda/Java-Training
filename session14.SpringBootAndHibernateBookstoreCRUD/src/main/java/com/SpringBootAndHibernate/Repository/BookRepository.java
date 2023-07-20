package com.SpringBootAndHibernate.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBootAndHibernate.Entity.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	public Book findByBookName(String bookName);

}
