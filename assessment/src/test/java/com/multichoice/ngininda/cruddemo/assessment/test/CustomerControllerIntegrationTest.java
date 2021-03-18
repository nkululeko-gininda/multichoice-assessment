package com.multichoice.ngininda.cruddemo.assessment.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.multichoice.ngininda.cruddemo.assessment.controller.CustomerController;
import com.multichoice.ngininda.cruddemo.assessment.model.Customer;
import com.multichoice.ngininda.cruddemo.assessment.repository.CustomerRepositoryInterface;
import com.multichoice.ngininda.cruddemo.assessment.service.CustomerService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private CustomerRepositoryInterface customerRepository;
	private CustomerService customerService;
	
	@Test
	void createCustomerRestApi() throws Exception {
		Customer customer= new  Customer();
		customer.setCustomerNumber("TC5");
		customer.setEmail("ginindancyprial@gmail.com");
		customer.setFirstName("Nkululeko");
		customer.setLastName("Gininda");

		ObjectMapper mapper = new ObjectMapper();
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/customer/", customer);
		MvcResult mvcResult = mvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
		
		assertEquals(200, mvcResult.getResponse().getStatus());
		
	}
	@Test
	void updateCustomerRestApi() throws Exception {
		Customer customer= new  Customer();
		customer.setCustomerNumber("TC2");
		customer.setEmail("gnc@gmail.com");
		customer.setFirstName("Cyprial");
		customer.setLastName("Gininda");
		ObjectMapper mapper = new ObjectMapper();
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/customer/",  customer);
		MvcResult mvcResult = mvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
	            .andReturn();
		
		assertEquals(customer, mvcResult.getRequest());
	}
	@Test
	void fecthCustomerByCustomerNumberRestApi() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customer/", "TC2");
		MvcResult mvcResult = mvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
		System.out.println(mvcResult.getResponse());
		
		assertThat(mvcResult.getResponse()).isNotNull();
		
	}
	@Test
	void fecthAllCustomersRestApi() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customer/");
		MvcResult mvcResult = mvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
		System.out.println(mvcResult.getResponse().getContentAsString());
		assertThat(mvcResult.getResponse().getContentAsString()).isNotNull();
		
	}
	@Test
	void deleteCustomerRestApi() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/customer/", "TC2");
		MvcResult mvcResult = mvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
		
		assertThat(mvcResult.getResponse().getContentAsString()).isEqualTo("OK");
		
	}

}
