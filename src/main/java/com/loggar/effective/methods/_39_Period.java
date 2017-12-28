package com.loggar.effective.methods;

import java.util.Date;

/**
 * Make defensive copies when needed
 *
 */
// Broken "immutable" time period class
public final class _39_Period {
	private final Date start;
	private final Date end;

	// Repaired constructor - makes defensive copies of parameters
	public _39_Period(Date start, Date end) {
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());
		if (this.start.compareTo(this.end) > 0)
			throw new IllegalArgumentException(start + " after " + end);
	}

	// Repaired accessors - make defensive copies of internal fields
	public Date start() {
		return new Date(start.getTime());
	}

	public Date end() {
		return new Date(end.getTime());
	}

	// Remainder omitted...

	// Attack the internals of a Period instance
	@SuppressWarnings("deprecation")
	public void test1() {
		Date start = new Date();
		Date end = new Date();
		_39_Period p = new _39_Period(start, end);
		end.setYear(78); // Modifies internals of p!
		System.out.println(p);

	}

	// Second attack on the internals of a Period instance
	@SuppressWarnings("deprecation")
	public void test2() {
		Date start = new Date();
		Date end = new Date();
		_39_Period p = new _39_Period(start, end);
		p.end().setYear(78); // Modifies internals of p!
	}
}
