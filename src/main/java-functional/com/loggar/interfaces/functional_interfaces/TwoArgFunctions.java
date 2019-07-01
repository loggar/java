package com.loggar.interfaces.functional_interfaces;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class TwoArgFunctions {
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
	public void bi_functions() {
		/*
		 * Until now, we have dealt with functions that only accept a single input
		 * argument. There are use cases that may have to operate on two arguments. For
		 * example, a function that expects two arguments but produces a result by
		 * operating on these two arguments. This type of functionality fits into
		 * two-argument functions bucket such as BiPredicate, BiConsumer, BiFunction,
		 * etc. They are pretty easy to understand too except that the signature will
		 * have an additional type (two input types and one return type). For instance,
		 * the BiFunction interface definition is shown below
		 * 
		 * @FunctionalInterface public interface BiFunction<T, U, R> { R apply(T t, U
		 * u); }
		 */

		BiFunction<Trade, Trade, Integer> sumQuantities = (t1, t2) -> {
			return t1.getQuantity() + t2.getQuantity();
		};
		int r = sumQuantities.apply(trades.get(0), trades.get(1));
		assertTrue(r == 10001001);
	}

	@Test
	public void bi_predicate() {
		// Predicate expecting two trades to compare and returning the condition's
		// output
		BiPredicate<Trade, Trade> isBig = (t1, t2) -> t1.getQuantity() > t2.getQuantity();
		boolean r = isBig.test(trades.get(0), trades.get(1));
		assertThat(r, is(false));
	}

	@Test
	public void bi_function_binaryOperator_1() {
		BiFunction<Trade, Trade, Trade> tradeMerger = (t1, t2) -> {
			t1.setQuantity(t1.getQuantity() + t2.getQuantity());
			return t1;
		};

		Trade t = tradeMerger.apply(trades.get(0), trades.get(1));
		assertTrue(t == trades.get(0));
		assertTrue(t.getQuantity() == 10001001);
	}

	@Test
	public void bi_function_binaryOperator_2() {
		/*
		 * Note that we did not pass in all three arguments when declaring the type
		 * (expectation is that all the inputs and outputs are of same type). Also, did
		 * you notice that the actual logic is carried out by the super function
		 * BiFunction rather than BinaryOperator? This is because the BinaryOperator
		 * extends the BiFunction:
		 */

		/*
		 * public interface BinaryOperator<T> extends BiFunction<T,T,T> { .. }
		 */

		BinaryOperator<Trade> tradeMerger = (t1, t2) -> {
			t1.setQuantity(t1.getQuantity() + t2.getQuantity());
			return t1;
		};

		Trade t = tradeMerger.apply(trades.get(0), trades.get(1));
		assertTrue(t == trades.get(0));
		assertTrue(t.getQuantity() == 10001001);
	}
}
