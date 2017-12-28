package com.loggar.effective.enums;

import java.util.HashMap;
import java.util.Map;

public enum _02_Operation {
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

	_02_Operation(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}

	abstract double apply(double x, double y);

	// Implementing a fromString method on an enum type
	private static final Map<String, _02_Operation> stringToEnum = new HashMap<String, _02_Operation>();
	static { // Initialize map from constant name to enum constant
		for (_02_Operation op : values())
			stringToEnum.put(op.toString(), op);
	}

	// Returns Operation for string, or null if string is invalid
	public static _02_Operation fromString(String symbol) {
		return stringToEnum.get(symbol);
	}

	// Switch on an enum to simulate a missing method
	public static _02_Operation inverse(_02_Operation op) {
		switch (op) {
		case PLUS:
			return _02_Operation.MINUS;
		case MINUS:
			return _02_Operation.PLUS;
		case TIMES:
			return _02_Operation.DIVIDE;
		case DIVIDE:
			return _02_Operation.TIMES;
		default:
			throw new AssertionError("Unknown op: " + op);
		}
	}

	public static void main(String[] args) {
		double x = 2;
		double y = 4;
		for (_02_Operation op : _02_Operation.values())
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));

		for (_02_Operation op : _02_Operation.values())
			System.out.printf("fromString %s \t%s%n", op.toString(), _02_Operation.fromString(op.toString()));
		
		for (_02_Operation op : _02_Operation.values())
			System.out.printf("inverse %s \t%s%n", op, _02_Operation.inverse(op));
	}
}
