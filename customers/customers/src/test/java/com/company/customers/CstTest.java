package com.company.customers;

import com.company.customers.entity.Customer;
import io.jmix.core.Id;
import io.jmix.core.UnconstrainedDataManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CstTest {

	@Autowired
	UnconstrainedDataManager dataManager;

	@Test
	void contextLoads() {
	}

	@Test
	void testCustomer() {
		Customer customer = dataManager.create(Customer.class);
		customer.setName("cust1");

		Customer customer1 = dataManager.save(customer);
		assertEquals(customer, customer1);

		Customer customer2 = dataManager.load(Id.of(customer)).one();
		assertEquals(customer, customer2);
	}
}
