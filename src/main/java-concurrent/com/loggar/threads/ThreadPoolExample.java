package com.loggar.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
	public static void main(String[] atrgs) {
		Runnable asteroid = () -> {
			System.out.println("Orbiting");
		};

		Thread asteroidThread1 = new Thread(asteroid);
		Thread asteroidThread2 = new Thread(asteroid);

		// Create thread manager
		ExecutorService threadExecutor = Executors.newFixedThreadPool(2);
		// Make threads runnable
		threadExecutor.execute(asteroidThread1);
		threadExecutor.execute(asteroidThread2);
		// Shut down threads
		threadExecutor.shutdown();
	}
}
