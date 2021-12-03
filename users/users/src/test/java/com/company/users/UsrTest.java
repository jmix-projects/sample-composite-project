package com.company.users;

import com.company.users.entity.User;
import io.jmix.core.DataManager;
import io.jmix.core.security.SystemAuthenticator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsrTest {

	@Autowired
	DataManager dataManager;

	@Autowired
	SystemAuthenticator systemAuthenticator;

	@BeforeEach
	void setUp() {
		systemAuthenticator.begin();
	}

	@AfterEach
	void tearDown() {
		systemAuthenticator.end();
	}

	@Test
	void contextLoads() {
	}

	@Test
	void testAdminUser() {
		User admin = dataManager.load(User.class).id(UUID.fromString("60885987-1b61-4247-94c7-dff348347f93")).one();
		assertEquals("admin", admin.getUsername());
	}
}
