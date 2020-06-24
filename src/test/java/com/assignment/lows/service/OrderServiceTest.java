package com.assignment.lows.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.assignment.lows.dao.OrderDAO;
import com.assignment.lows.model.Order;
import com.assignment.lows.model.Person;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

	@InjectMocks
	OrderService orderService;

	@Mock
	private OrderDAO orderDAO;

	@Test(expected = RuntimeException.class)
	public void testModifyOrder() {
		Order order = new Order();
		Person p = new Person();
		p.setName("test");
		p.setPhoneNumber(1234567890l);
		order.setOrderId("1");
		order.setPerson(p);
		order.setShippingAddress("CBM");
		orderService.modifyOrder(order);
		orderService.modifyOrder(null);
	}

	@Test
	public void testCreateOrder() {

		Order order = new Order();
		Person p = new Person();
		p.setName("test");
		p.setPhoneNumber(1234567890l);
		order.setOrderId("1");
		order.setPerson(p);
		order.setShippingAddress("CBM");
		when(orderDAO.save(any())).thenReturn(order);
		orderService.createOrder(order);
	}

	@Test(expected = RuntimeException.class)
	public void testDeleteOrder() {
		Order order = new Order();
		Person p = new Person();
		p.setName("test");
		p.setPhoneNumber(1234567890l);
		order.setOrderId("1");
		order.setPerson(p);
		order.setShippingAddress("CBM");
		Optional<Order> orderObj = Optional.of(order);
		when(orderDAO.findById(anyString())).thenReturn(orderObj);
		orderService.deleteOrder("1");
		when(orderDAO.findById(anyString())).thenReturn(Optional.empty());
		orderService.deleteOrder("1");
	}

	@Test(expected = RuntimeException.class)
	public void testFetchOrder() {
		Order order = new Order();
		Person p = new Person();
		p.setName("test");
		p.setPhoneNumber(1234567890l);
		order.setOrderId("1");
		order.setPerson(p);
		order.setShippingAddress("CBM");
		Optional<Order> orderObj = Optional.of(order);

		when(orderDAO.findById(anyString())).thenReturn(orderObj);
		orderService.fetchOrder("1L");
		when(orderDAO.findById(anyString())).thenReturn(Optional.empty());
		orderService.fetchOrder("1");
	}

	@Test
	public void testFetchAllOrders() {

		List<Order> orders = new ArrayList<>();
		Order order = new Order();
		Person p = new Person();
		p.setName("test");
		p.setPhoneNumber(1234567890l);
		order.setOrderId("1");
		order.setPerson(p);
		order.setShippingAddress("CBM");
		orders.add(order);
		when(orderDAO.findAll()).thenReturn(orders);
		orderService.fetchAllOrders();
	}
	
	@Test(expected = RuntimeException.class)
	public void testFetchAllOrders1() {
		when(orderDAO.findAll()).thenReturn(null);
		orderService.fetchAllOrders();
	}

}
