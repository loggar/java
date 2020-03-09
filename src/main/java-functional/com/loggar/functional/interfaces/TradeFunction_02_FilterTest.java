package com.loggar.functional.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TradeFunction_02_FilterTest {
	// Method that takes in list of trades and applies the lambda behavior for each
	// of the trade in the collection
	private List<Trade> filterTrades(TradeFunction tradeLambda, List<Trade> trades) {
		List<Trade> newTrades = new ArrayList<>();

		for (Trade trade : trades) {
			if (tradeLambda.check(trade)) {
				newTrades.add(trade);
			}
		}
		return newTrades;
	}

	List<Trade> trades = null;

	@Before
	public void before() {
		trades = new ArrayList<>();
		trades.add(new Trade("NEW", "GOOD", 1000));
		trades.add(new Trade("NEW", "GOOD", 10000001));
		trades.add(new Trade("OLD", "GOOD", 1000));
		trades.add(new Trade("NEW", "BAD", 10000001));
		trades.add(new Trade("OLD", "BAD", 1000));
		trades.add(new Trade("NEW", "GOOD", 10000001));
	}

	@Test
	public void test1() {
		// Big trades function is passed
		TradeFunction bigTradesFilter = (Trade t) -> t.getQuantity() > 10000000;
		List<Trade> bigTrades = filterTrades(bigTradesFilter, trades);
		System.out.println("bigTrades.size: " + bigTrades.size());
	}

	@Test
	public void test2() {
		// "BIG+NEW+ISSUER" function is passed
		TradeFunction bigNewIssuerTradesFilter = (t) -> t.getQuantity() > 10000000 && t.getStatus().equals("NEW") && t.getIssuer().equals("GOOD");
		List<Trade> bigNewIssuerTrades = filterTrades(bigNewIssuerTradesFilter, trades);
		System.out.println("bigNewIssuerTrades.size: " + bigNewIssuerTrades.size());
	}
}
