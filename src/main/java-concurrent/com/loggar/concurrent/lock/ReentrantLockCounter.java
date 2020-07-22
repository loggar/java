package com.loggar.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter {
	private final ReentrantLock lock = new ReentrantLock();

	private int count = 0;

	// Thread Safe Increment
	public void increment() {
		lock.lock();
		try {
			count = count + 1;
		} finally {
			lock.unlock();
		}
	}
}
