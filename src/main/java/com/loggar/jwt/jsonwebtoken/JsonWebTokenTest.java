package com.loggar.jwt.jsonwebtoken;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.jsonwebtoken.Claims;

public class JsonWebTokenTest {
	@Test
	public void generate() {
		long expireMillis = 60 * 1000;

		JsonWebToken jwt = new JsonWebToken();
		String token1 = jwt.generate("loggar", "Y", "SubjectValue", expireMillis);
		System.out.println(token1);

		String token2 = jwt.generate("loggar", "Y", "SubjectValue", expireMillis);
		System.out.println(token2);

		Claims claims1 = jwt.decode(token1);
		Claims claims2 = jwt.decode(token2);

		System.out.println(claims1);
		System.out.println(claims2);
		
		assertTrue(claims1.getId().equals(claims2.getId()));
	}
}
