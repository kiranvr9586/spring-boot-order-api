package com.assignment.lows.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.assignment.lows.model.Person;

@Repository
public interface PersonDAO extends MongoRepository<Person, String> {


}
