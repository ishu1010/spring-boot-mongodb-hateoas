package com.example.spring.mongo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.mongo.model.Order;
@Repository
public interface OrderRepository extends MongoRepository<Order, Integer> {
	
	public Optional<Order> findById(Integer id);
	

}
