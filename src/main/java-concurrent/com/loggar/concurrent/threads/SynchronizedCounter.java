package com.loggar.concurrent.threads;

public class SynchronizedCounter {
	private int count = 0;

	// Synchronized Method
	public synchronized void increment() {
		count = count + 1;
	}

	public int getCount() {
		return count;
	}
}
