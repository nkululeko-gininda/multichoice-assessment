package com.multichoice.ngininda.cruddemo.assessment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multichoice.ngininda.cruddemo.assessment.model.Customer;
import com.multichoice.ngininda.cruddemo.assessment.repository.CustomerRepositoryInterface;

@Service
public class CustomerService {

	@Autowired
	CustomerRepositoryInterface customerRepositoryInterface;
	
	public CustomerService() {
		
	}
	
	public Customer create(Customer customer) {
		return customerRepositoryInterface.insert(customer);
	}
	public String delete(Customer customer) {
		try {
			customerRepositoryInterface.delete(customer);
			return "OK";
		}catch(Exception e) {
			e.printStackTrace();
			return "Fail";
		}
	}
	public Customer update(Customer customer) {
		return customerRepositoryInterface.save(customer);
	}
	public Customer getCustomer(int id) {
		if(customerRepositoryInterface.findById(id).isPresent())
			return customerRepositoryInterface.findById(id).get();
		else
			return null;
	}
	public Customer getCustomerByCustomerNumber(String customerNumber) {
		if(customerRepositoryInterface.findByCustomerNumber(customerNumber) != null)
			return customerRepositoryInterface.findByCustomerNumber(customerNumber);
		else
			return null;
	}
	public List<Customer> getAllCustomers(){
		List<Customer> customerList = (List<Customer>) customerRepositoryInterface.findAll();
		return customerList;
	}
}
