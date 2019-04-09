package com.loggar.concurrent.threads;

public class SynchronizedBlockExample {
	private int count = 0;

	public void increment() {
		// Synchronized Block -

		// Acquire Lock
		synchronized (this) {
			count = count + 1;
		}
		// Release Lock
	}
}
