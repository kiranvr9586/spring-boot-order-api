package com.assignment.lows.model;

import java.util.Collections;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
public class Order {
	
	public static final String SEQUENCE_NAME = "orders_sequence"; 

	@Id
	private String orderId;
	
	private List<Item> items;
	
	private String shippingAddress;
	
	private Person person;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public List<Item> getItems() {
		return Collections.unmodifiableList(items);
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
