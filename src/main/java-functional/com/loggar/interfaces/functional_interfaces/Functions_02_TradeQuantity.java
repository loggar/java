package com.loggar.interfaces.functional_interfaces;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class Functions_02_TradeQuantity {
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
	public void argAndReturn() {
		// Function to calculate the aggregated quantity of all the trades - taking in a
		// collection and returning an integer!
		Function<List<Trade>, Integer> aggegatedQuantity = t -> {
			int aggregatedQuantity = 0;
			for (Trade trade : t) {
				aggregatedQuantity += trade.getQuantity();
			}
			return aggregatedQuantity;
		};

		int x = aggegatedQuantity.apply(trades);
		assertTrue(x == 30003003);
	}

	@Test
	public void fluentStyleAggregation() {
		// Using Stream and map and reduce functionality

		int aggregatedQuantity = trades.stream().map((t) -> t.getQuantity()).reduce(0, Integer::sum);
		assertTrue(aggregatedQuantity == 30003003);
	}
}
