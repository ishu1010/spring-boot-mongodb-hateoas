package com.example.spring.mongo.dto;

public class BookDTO {
	private int id;
	private String name;
	private String author;
	private Double price;

	public BookDTO() {
		super();
	}

	public BookDTO(int id, String name, String author, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookDTO [id=" + id + ", name=" + name + ", author=" + author + ", price=" + price + "]";
	}

}
