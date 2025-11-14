package com.chubb.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Order {
	
	@NotBlank
	private String item;
	
	@Min(value = 1)
	private float price;
	
	@Min(value = 1)
	private int quantity;
	private double total;
	
	private Address address;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;   
    }
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
