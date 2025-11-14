package com.chubb.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Order {
	
	@NotBlank
	private String item;
	
	@Min(value = 1)
	private float price;
	private int quantity;
	private double total;
	
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
