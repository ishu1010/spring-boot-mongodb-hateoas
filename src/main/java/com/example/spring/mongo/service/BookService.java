package com.example.spring.mongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.spring.mongo.model.Book;
import com.example.spring.mongo.repository.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	//GET BY ID
	public Optional<Book> getBook(Integer id) {
		return bookRepository.findById(id);
	}
	//GET ALL RECORD
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	//SAVE
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	//UPDATE
	public Book updateBook(Book book) {
		return saveBook(book);
	}
	
	//DELETE
		public void deleteBook(Book book) {
			 bookRepository.delete(book);
		}

}
