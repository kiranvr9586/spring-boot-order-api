package com.assignment.lows.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.lows.dao.AddressDAO;
import com.assignment.lows.dao.OrderDAO;
import com.assignment.lows.dao.PersonDAO;
import com.assignment.lows.model.Order;

@Service
public class OrderService {
	
	@Autowired 
	private AddressDAO addressDAO;
	
	@Autowired 
	private OrderDAO orderDAO;
	
	@Autowired 
	private PersonDAO personDAO;
	
	public Order modifyOrder(Order order) {
		if(order!=null) {
		orderDAO.save(order);
		return order;
		}
		else {
			throw new RuntimeException("Order not found for id ");
		}
		
	
	}
	
	public Order createOrder(Order order) {
		orderDAO.save(order);
		return order;
	}
	
	public Order deleteOrder(String id) {
		Optional<Order> orderObj = orderDAO.findById(id);
		if(orderObj.isPresent()) {
			orderDAO.delete(orderObj.get());
			return orderObj.get();
		}else {
			throw new RuntimeException("Order not found for id "+id);
	}
	}
		
	public Order fetchOrder(String id) {
			Optional<Order> orderObj = orderDAO.findById(id);
			if(orderObj.isPresent()) {
				return orderObj.get();
			}else {
				throw new RuntimeException("Order not found with id "+id);
			}
		}
	
	public List<Order> fetchAllOrders() {
		List<Order> orders = orderDAO.findAll();
		if(null != orders && !orders.isEmpty() ) {
			return orders;
		}else {
			throw new RuntimeException("No orders");
		}
	}

}

