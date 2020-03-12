package com.loggar.test.junit5.sequence;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class MethodOrderTest {
	@Order(3)
	@Test
	void checkoutOrder() {
		System.out.println("checkoutOrder");
	}

	@Order(2)
	@Test
	void addItemsInBasket() {
		System.out.println("addItemsInBasket");
	}

	@Order(1)
	@Test
	void createUserAndLogin() {
		System.out.println("createUserAndLogin");
	}
}
