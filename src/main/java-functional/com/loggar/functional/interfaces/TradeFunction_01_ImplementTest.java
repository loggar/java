package com.loggar.functional.interfaces;

import org.junit.Test;

public class TradeFunction_01_ImplementTest {
	@Test
	public void test1() {
		TradeFunction newTradeChecker = (Trade t) -> t.getStatus().equals("NEW");
		// Or we could omit the input type setting:
		// ITrade newTradeChecker = (t) -> t.getStatus().equals("NEW");

		boolean check = newTradeChecker.check(new Trade("NEW", "GOOD", 1000));
		System.out.println(check);
	}

	@Test
	public void test2() {
		// Lambda for big trade
		TradeFunction bigTradeLambda = (Trade t) -> t.getQuantity() > 10000000;
		System.out.println(bigTradeLambda.check(new Trade("NEW", "GOOD", 1000)));
	}

	@Test
	public void test3() {
		// Lambda that checks if the trade is a new large google trade
		TradeFunction issuerBigNewTradeLambda = (t) -> {
			return t.getIssuer().equals("GOOD") && t.getQuantity() > 10000000 && t.getStatus().equals("NEW");
		};
		System.out.println(issuerBigNewTradeLambda.check(new Trade("NEW", "GOOD", 1000)));
	}
}
