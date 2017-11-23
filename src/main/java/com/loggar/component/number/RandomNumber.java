package com.loggar.component.number;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumber {
	// Simple test which prints random number between min and max number (Number Range Example)
	public void RandomTest1() throws InterruptedException {
		while (true) {
			int min = 5;
			int max = 15;

			float randomNumber = (min + (float) (Math.random() * ((max - min))));
			System.out.println("Test1: " + randomNumber);
			Thread.sleep(500);
		}
	}

	// Simple test which prints random entry from list below
	public void RandomTest2() throws InterruptedException {
		List<String> list = new ArrayList<String>();
		list.add("eBay");
		list.add("Paypal");
		list.add("Google");

		Random randomNumber = new Random();
		String randomEle;
		int listSize = list.size();

		while (true) {
			randomEle = list.get(randomNumber.nextInt(listSize));
			System.out.println("Test2: " + randomEle);
			Thread.sleep(800);
		}
	}

	static public void main(String[] args) {
		// Let's run both Test1 and Test2 methods in parallel..
		Thread thread1 = new Thread() {
			public void run() {
				RandomNumber cr = new RandomNumber();
				try {
					cr.RandomTest1();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread thread2 = new Thread() {
			public void run() {
				RandomNumber cr = new RandomNumber();
				try {
					cr.RandomTest2();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		thread1.start();
		thread2.start();
	}
}
