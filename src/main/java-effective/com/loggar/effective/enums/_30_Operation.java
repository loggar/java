package com.loggar.effective.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Use enums instead of int constants
 *
 */
public enum _30_Operation {
	PLUS("+") {
		double apply(double x, double y) {
			return x + y;
		}
	},
	MINUS("-") {
		double apply(double x, double y) {
			return x - y;
		}
	},
	TIMES("*") {
		double apply(double x, double y) {
			return x * y;
		}
	},
	DIVIDE("/") {
		double apply(double x, double y) {
			return x / y;
		}
	};
	private final String symbol;

	_30_Operation(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}

	abstract double apply(double x, double y);

	// Implementing a fromString method on an enum type
	private static final Map<String, _30_Operation> stringToEnum = new HashMap<String, _30_Operation>();
	static { // Initialize map from constant name to enum constant
		for (_30_Operation op : values())
			stringToEnum.put(op.toString(), op);
	}

	// Returns Operation for string, or null if string is invalid
	public static _30_Operation fromString(String symbol) {
		return stringToEnum.get(symbol);
	}

	// Switch on an enum to simulate a missing method
	public static _30_Operation inverse(_30_Operation op) {
		switch (op) {
		case PLUS:
			return _30_Operation.MINUS;
		case MINUS:
			return _30_Operation.PLUS;
		case TIMES:
			return _30_Operation.DIVIDE;
		case DIVIDE:
			return _30_Operation.TIMES;
		default:
			throw new AssertionError("Unknown op: " + op);
		}
	}

	public static void main(String[] args) {
		double x = 2;
		double y = 4;
		for (_30_Operation op : _30_Operation.values())
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));

		for (_30_Operation op : _30_Operation.values())
			System.out.printf("fromString %s \t%s%n", op.toString(), _30_Operation.fromString(op.toString()));
		
		for (_30_Operation op : _30_Operation.values())
			System.out.printf("inverse %s \t%s%n", op, _30_Operation.inverse(op));
	}
}
