package com.assignment.lows.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.assignment.lows.model.Item;

public interface ItemDAO extends MongoRepository<Item, String>{

}
