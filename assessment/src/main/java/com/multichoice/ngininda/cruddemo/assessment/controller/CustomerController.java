package com.multichoice.ngininda.cruddemo.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonProperties;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.multichoice.ngininda.cruddemo.assessment.model.Customer;
import com.multichoice.ngininda.cruddemo.assessment.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PutMapping(path="/",  consumes="application/json",  produces="application/json")
	public Customer addCustomer(@RequestBody String customer) {
		ObjectMapper mapper = new ObjectMapper();
		Customer c = mapper.convertValue(customer, Customer.class);
		
		return customerService.create(c);
	}
	@PostMapping(path="/",  consumes="application/json",  produces="application/json")
	public Customer updateCustomer(@RequestBody String customer) {
		ObjectMapper mapper = new ObjectMapper();
		Customer c = mapper.convertValue(customer, Customer.class);
		return customerService.update(c);
	}
	@DeleteMapping(path="/{customerNumber}", produces="application/json")
	public String deleteCustomer(@PathVariable String customerNumber) {
		Customer customer = customerService.getCustomerByCustomerNumber(customerNumber);
		return customerService.delete(customer);
	}
	@GetMapping(path="/{customerNumber}", produces="application/json")
	public Customer getCustomerByCustomerNumber(@PathVariable String customerNumber) {
		return customerService.getCustomerByCustomerNumber(customerNumber);
	}
	@GetMapping(path="/", produces="application/json")
	public List<Customer> getCustomerList() {
		return customerService.getAllCustomers();
	}
	@GetMapping(path="", produces="application/json")
	public List<Customer> index() {
		return customerService.getAllCustomers();
	}
	
	
}
