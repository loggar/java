package com.loggar.concurrent.callable_future;

//Code is almost same as the previous example with a 
//few changes made to use Runnable instead of Callable 
public class RunnableTest {
	public static void main(String[] args) throws Exception {
		RunnableExample[] randomNumberTasks = new RunnableExample[5];

		for (int i = 0; i < 5; i++) {
			randomNumberTasks[i] = new RunnableExample();
			Thread t = new Thread(randomNumberTasks[i]);
			t.start();
		}

		for (int i = 0; i < 5; i++)
			System.out.println(randomNumberTasks[i].get());
	}
}
