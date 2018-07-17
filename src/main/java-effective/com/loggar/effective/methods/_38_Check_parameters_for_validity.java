package com.loggar.effective.methods;

import java.math.BigInteger;

public class _38_Check_parameters_for_validity {
	/**
	 * Returns a BigInteger whose value is (this mod m). This method differs from
	 * the remainder method in that it always returns a non-negative BigInteger.
	 *
	 * @param m
	 *            the modulus, which must be positive
	 * @return this mod m
	 * @throws ArithmeticException
	 *             if m is less than or equal to 0
	 */
	public BigInteger mod(BigInteger m) {
		if (m.signum() <= 0)
			throw new ArithmeticException("Modulus <= 0: " + m);

		// Do the computation

		return m;
	}

	/*
	 * Nonpublic methods should generally check their parameters using assertions,
	 * as shown below:
	 */
	// Private helper function for a recursive sort
	@SuppressWarnings("unused")
	private static void sort(long a[], int offset, int length) {
		assert a != null;
		assert offset >= 0 && offset <= a.length;
		assert length >= 0 && length <= a.length - offset;
		// Do the computation
	}
}
