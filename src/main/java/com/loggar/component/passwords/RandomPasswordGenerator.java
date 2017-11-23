package com.loggar.component.passwords;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

public class RandomPasswordGenerator {
	// SecureRandom() constructs a secure random number generator (RNG) implementing the default random number algorithm.
	private SecureRandom randomNo = new SecureRandom();

	private ArrayList<Object> valueObj;

	public static void main(String[] args) {
		RandomPasswordGenerator passwordGenerator = new RandomPasswordGenerator();

		System.out.println("Password Generator Utility: \n");
		StringBuilder buffer = new StringBuilder();

		// Let's print total 8 passwords
		for (int loop = 1; loop <= 8; loop++) {
			// Password length should be 23 characters
			for (int length = 0; length < 23; length++) {
				buffer.append(passwordGenerator.getRandom());
			}

			System.out.println(loop + ": " + buffer.toString());
			buffer.setLength(0);
		}
	}

	// Just initialize ArrayList valueObj and add ASCII Decimal Values
	public RandomPasswordGenerator() {
		valueObj = new ArrayList<>();

		// Adding ASCII Decimal value between 33 and 53
		for (int i = 33; i < 53; i++) {
			valueObj.add((char) i);
		}

		// Adding ASCII Decimal value between 54 and 85
		for (int i = 54; i < 85; i++) {
			valueObj.add((char) i);
		}

		// Adding ASCII Decimal value between 86 and 128
		for (int i = 86; i < 127; i++) {
			valueObj.add((char) i);
		}
		valueObj.add((char) 64);

		// rotate() rotates the elements in the specified list by the specified distance. This will create strong password
		Collections.rotate(valueObj, 5);
	}

	// Get Char value from above added Decimal values
	// Enable Logging below if you want to debug
	public char getRandom() {
		return (char) this.valueObj.get(randomNo.nextInt(this.valueObj.size()));
	}
}
