package com.loggar.threads;

import org.junit.jupiter.api.Test;

public class RunnableThreadsLamda {
	private void orbit() {
		System.out.println("Orbiting");
	}

	@Test
	public void runnableThreads() {
		Runnable asteroid = () -> {
			orbit();
		};

		Thread asteroidThread1 = new Thread(asteroid);
		Thread asteroidThread2 = new Thread(asteroid);

		asteroidThread1.run();
		asteroidThread2.run();
	}
}
