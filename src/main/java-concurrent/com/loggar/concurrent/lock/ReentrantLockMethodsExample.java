package com.loggar.concurrent.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReentrantLockMethodsExample {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		ReentrantLockMethodsCounter lockMethodsCounter = new ReentrantLockMethodsCounter();

		executorService.submit(() -> {
			System.out.println("IncrementCount (First Thread) : " + lockMethodsCounter.incrementAndGet() + "\n");
		});

		executorService.submit(() -> {
			System.out.println("IncrementCount (Second Thread) : " + lockMethodsCounter.incrementAndGet() + "\n");
		});

		executorService.shutdown();
	}
	
	/*
	 * You can also specify a timeout in the tryLock() method to wait for the lock to be available -
	 * 
	 * lock.tryLock(1, TimeUnit.SECONDS);
	 */
}
