package com.loggar.concurrent.threads;

import org.junit.Test;

public class RunnableThreads implements Runnable {
	public void run() {
		orbit();
	}

	private void orbit() {
		System.out.println("Orbiting");
	}
	
	@Test
	public void runnableThreads() {
		Thread majaThread1 = new Thread(new RunnableThreads());
		Thread majaThread2 = new Thread(new RunnableThreads());
		majaThread1.run();
		majaThread2.run();
	}
}
