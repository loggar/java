package com.loggar.test.junit5;

public class LinearSearcher {
	private int[] data;

	LinearSearcher(int[] arr) {
		this.data = arr;
	}

	int getPositionOfNumber(int value) {
		int n = data.length;
		for (int p = 0; p < n; p++) {
			if (data[p] == value) return p;
		}
		return -1;
	}
}
