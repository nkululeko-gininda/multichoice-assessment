package com.multichoice.ngininda.cruddemo.assessment.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.multichoice.ngininda.cruddemo.assessment.model.Customer;

@Repository
public interface CustomerRepositoryInterface extends MongoRepository<Customer, Integer>{
	List<Customer> findAll();
	Customer findByCustomerNumber(String  customerNumber);
}
