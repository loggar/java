package com.loggar.concurrent.sync;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class MehodNonSyncTest {
	private static class Counter {
		private int count;

		public void increase() throws InterruptedException {
			TimeUnit.MILLISECONDS.sleep(10); // for generate thread inference
			count += 1;
		}

		public void print() {
			System.out.println(count);
		}
	}

	@Test
	public void synchronizeTest1() throws InterruptedException {
		// 1. create shared instance
		final Counter counter = new Counter();

		// create list.
		final List<Thread> list = new LinkedList<>();

		// 2. add 100 threads
		IntStream.range(0, 100).forEach(i -> list.add(new Thread(() -> {
			try {
				counter.increase();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		})));

		// 3. each thread starts to increase
		list.forEach(Thread::start);

		// 4. wait for all the threads finish
		list.forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		// 5. print result
		counter.print();
	}
}
