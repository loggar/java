package com.loggar.interfaces.functional_interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

/**
 * implementation java.util.function.Predicate
 * 
 * @FunctionalInterface public interface Predicate<T> { boolean test(T t); }
 *
 */
public class TradeFunction_03_PredicateTest {
	// Method that takes in list of trades and applies the lambda behavior for each
	// of the trade in the collection
	private List<Trade> filterTrades(Predicate<Trade> tradeLambda, List<Trade> trades) {
		List<Trade> newTrades = new ArrayList<>();

		for (Trade trade : trades) {
			if (tradeLambda.test(trade)) {
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
		// A large trade (this time using library function)!
		Predicate<Trade> bigTradesFilter = (Trade t) -> t.getQuantity() > 10000000;
		List<Trade> bigTrades = filterTrades(bigTradesFilter, trades);
		System.out.println("bigTrades.size: " + ((List<Trade>) bigTrades).size());
	}
}
