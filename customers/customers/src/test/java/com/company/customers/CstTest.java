package com.company.customers;

import com.company.customers.entity.Announcement;
import com.company.customers.entity.Customer;
import com.company.users.entity.InstantDatatype;
import io.jmix.core.Id;
import io.jmix.core.Metadata;
import io.jmix.core.UnconstrainedDataManager;
import io.jmix.core.metamodel.model.MetaClass;
import io.jmix.core.metamodel.model.MetaProperty;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CstTest {

	@Autowired
	UnconstrainedDataManager dataManager;

	@Autowired
	Metadata metadata;

	@Test
	void contextLoads() {
	}

	@Test
	void testCustomer() {
		Customer customer = dataManager.create(Customer.class);
		customer.setName("cust1");
		Instant now = Instant.now();
		customer.setNotifyAt(now);

		Customer customer1 = dataManager.save(customer);
		assertEquals(customer, customer1);

		Customer customer2 = dataManager.load(Id.of(customer)).one();
		assertEquals(customer, customer2);
		assertEquals(now, customer2.getNotifyAt());
	}

	@Test
	void testAnnouncement() {
		Announcement announcement = metadata.create(Announcement.class);

		MetaClass metaClass = metadata.getClass(Announcement.class);
		MetaProperty metaProperty = metaClass.getProperty("time");

		assertEquals(InstantDatatype.ID, metaProperty.getRange().asDatatype().getId());
	}
}
