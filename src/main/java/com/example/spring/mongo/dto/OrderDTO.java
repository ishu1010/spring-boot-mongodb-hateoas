package com.example.spring.mongo.dto;

public class OrderDTO {
	private int id;
	private String item_catagory;
	private String item;
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
