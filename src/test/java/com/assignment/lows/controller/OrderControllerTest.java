package com.assignment.lows.controller;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.assignment.lows.exception.ResourceNotFoundException;
import com.assignment.lows.model.Order;
import com.assignment.lows.model.Person;
import com.assignment.lows.service.OrderService;
import com.assignment.lows.service.SequenceGeneratorService;


@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	@InjectMocks
	OrderController orderController;
	
	@Mock
	OrderService orderService;

	@Mock
	SequenceGeneratorService seqGeneratorService;
	@Test
	public void testgetAllOrders() {
		List<Order> orders=new ArrayList<Order>();
		Order o=new Order();
		Person p=new Person();
		p.setName("test");
		p.setPhoneNumber(1234567890l);
		o.setOrderId("1");
		o.setPerson(p);
		o.setShippingAddress("CBM");
		orders.add(o);	
		orderController.fetchAllOrders();
	}
	
	
	@Test
	public void testgetOrderById() throws ResourceNotFoundException {
		
		orderController.fetchOrder(anyString());
	}
	
	@Test
	public void testcreateOrder() throws ResourceNotFoundException {
		Order o=new Order();
		Person p=new Person();
		p.setName("test");
		p.setPhoneNumber(1234567890l);
		o.setOrderId("1");
		o.setPerson(p);
		o.setShippingAddress("CBM");
		
		seqGeneratorService.generateSequence(Order.SEQUENCE_NAME);
		 when(seqGeneratorService.generateSequence(anyString())).thenReturn(1L);
		orderController.create(o);
	}

	@Test
	public void testupdateOrder() throws ResourceNotFoundException {
		Order o=new Order();
		Person p=new Person();
		p.setName("test");
		p.setPhoneNumber(1234567890l);
		o.setOrderId("1");
		o.setPerson(p);
		o.setShippingAddress("CBM");
		orderController.updateOrder(o);
	}
	
	@Test
	public void testdeleteOrder() throws ResourceNotFoundException {
		orderController.deleteOrder("1");
	}
}
