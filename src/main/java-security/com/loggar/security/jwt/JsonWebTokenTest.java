package com.loggar.security.jwt;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.jsonwebtoken.Claims;

public class JsonWebTokenTest {
	@Test
	public void test() {
		long expireMillis = 60 * 1000;

		JsonWebToken jwt = new JsonWebToken();
		String token1 = jwt.sign("3ee9364e-8aca-4e39-8ba2-74e654c7e083", "https://domain_1.com", "forCommunicateWithSomething",
				expireMillis);
		System.out.println(token1);

		String token2 = jwt.sign("3ee9364e-8aca-4e39-8ba2-74e654c7e083", "https://domain_2.com", "forCommunicateWithSomething", expireMillis);
		System.out.println(token2);

		Claims claims1 = jwt.verify(token1);
		Claims claims2 = jwt.verify(token2);

		System.out.println(claims1);
		System.out.println(claims2);

		assertTrue(claims1.getId().equals(claims2.getId()));
	}
}
