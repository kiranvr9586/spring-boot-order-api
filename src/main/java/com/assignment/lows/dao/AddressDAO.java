package com.assignment.lows.dao;

import org.apache.tomcat.jni.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressDAO extends MongoRepository<Address, String>{
	

}
