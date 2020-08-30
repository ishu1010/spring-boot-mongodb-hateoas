package com.example.spring.mongo.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Order {
	
	@Field("id")
	private int id;
	@Field("item_catagory")
	private String item_catagory;
	@Field("item")
	private String item;
	@Field("amount")
	private double amount;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getItem_catagory() {
		return item_catagory;
	}
	public void setItem_catagory(String item_catagory) {
		this.item_catagory = item_catagory;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
