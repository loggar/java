package com.loggar.effective.general_programming;

import java.util.concurrent.TimeUnit;

public class _66_Synchronize_access_to_shared_mutable_data {
	// Properly synchronized cooperative thread termination
	private static boolean stopRequested = false;

	private static synchronized void requestStop() {
		stopRequested = true;
	}

	private static synchronized boolean stopRequested() {
		return stopRequested;
	}

	public static void main(String[] args) throws InterruptedException {
		Thread backgroundThread = new Thread(new Runnable() {
			public void run() {
				while (!stopRequested())
					System.out.println("running..");
				System.out.println("stop.");
			}
		});
		backgroundThread.start();
		TimeUnit.SECONDS.sleep(1);
		requestStop();
	}
}
