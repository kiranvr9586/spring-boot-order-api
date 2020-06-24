package com.assignment.lows.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.assignment.lows.model.Order;

@Repository
public interface OrderDAO extends MongoRepository<Order, String> {

}
