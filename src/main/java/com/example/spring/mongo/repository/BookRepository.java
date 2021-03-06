package com.example.spring.mongo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.mongo.model.Book;
@Repository
public interface BookRepository extends MongoRepository<Book, Integer> {
	
	public Optional<Book> findById(Integer id);
	

}
