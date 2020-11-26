package com.loggar.concurrent.threads;

import java.util.concurrent.TimeUnit;

public class TimeUnitSample {
	public static void main(String... args) throws InterruptedException {
		TimeUnit tu = TimeUnit.DAYS;
		long noOfDays = tu.convert(48, TimeUnit.HOURS);
		System.out.println("noOfDays:" + noOfDays);
		TimeUnit.SECONDS.sleep(2);
		Thread th = new Thread(new TimeUnitSample().new RunnableThread());
		th.start();
		TimeUnit.SECONDS.timedJoin(th, 5);
		System.out.println("done");
	}

	// runnable thread
	class RunnableThread implements Runnable {
		@Override
		public void run() {
			int cnt = 0;
			for (; cnt < 5; cnt++) {
				System.out.println("run:" + cnt);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
