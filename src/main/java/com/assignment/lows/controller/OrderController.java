package com.assignment.lows.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.lows.model.Order;
import com.assignment.lows.service.OrderService;
import com.assignment.lows.service.SequenceGeneratorService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;

	@Autowired
	SequenceGeneratorService seqGeneratorService;

	@PostMapping("/create")
	public ResponseEntity<Order> create(@RequestBody Order newOrderObject) {
		newOrderObject.setOrderId(String.valueOf(seqGeneratorService.generateSequence(Order.SEQUENCE_NAME)));
		return new ResponseEntity<>(orderService.createOrder(newOrderObject), HttpStatus.OK);
	}

	@GetMapping("/fetch")
	public ResponseEntity<List<Order>> fetchAllOrders() {
		return new ResponseEntity<>(orderService.fetchAllOrders(), HttpStatus.OK);
	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<Order> fetchOrder(@PathVariable String id) {
		return new ResponseEntity<>(orderService.fetchOrder(id), HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Order> updateOrder(@RequestBody Order modifiedOrderObject) {
		return new ResponseEntity<>(orderService.modifyOrder(modifiedOrderObject), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Order> deleteOrder(@PathVariable String id) {
		return new ResponseEntity<>(orderService.deleteOrder(id), HttpStatus.OK);
	}
}
