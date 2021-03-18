package com.multichoice.ngininda.cruddemo.assessment.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.multichoice.ngininda.cruddemo.assessment.model.Customer;
import com.multichoice.ngininda.cruddemo.assessment.service.CustomerService;

@RunWith(SpringRunner.class)
public class CustomerServiceIntegrationTest {

	@Autowired
	CustomerService customerService;
	
	@Test
	void createCustomer() {
		Customer customer= new  Customer();
		customer.setCustomerNumber("TC2");
		customer.setEmail("ginindancyprial@gmail.com");
		customer.setFirstName("Nkululeko");
		customer.setLastName("Gininda");
		
		assertThat(customerService.create(customer)).isEqualTo(customer);
		
	}
	@Test
	void getCustomers() {
		final List<Customer> customerList = customerService.getAllCustomers();
		assertThat(customerList).isNotEmpty();
		
	}
	
	@Test
	void getCustomerByCustomernumber() {
		final Customer customer = customerService.getCustomerByCustomerNumber("TC2");
		assertThat(customer).isNotNull();
		
	}
	
	@Test
	void updateCustomer() {
		Customer customer= new  Customer();
		customer.setCustomerNumber("TC2");
		customer.setEmail("gnc@gmail.com");
		customer.setFirstName("Cyprial");
		customer.setLastName("Gininda");
		
		final Customer result = customerService.update(customer);
		assertEquals(customer, result);
		
	}
	
	@Test
	void deleteCustomer() {
		Customer customer = customerService.getCustomerByCustomerNumber("TC2");
		final String result = customerService.delete(customer);
		assertEquals(result, "OK");
		
	}

}
