package com.example.spring.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Book {
	@Id
	private Integer id;
	private String name;
	private String author;
	private Double price;
	
	public Book() {
		super();
	}

	public Book(Integer id, String name, String author, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public Double getPrice() {
		return price;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
