package com.loggar.environments.system;

import java.io.File;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GetProcessEnvironment {
	public static void main(String a[]) {
		ProcessBuilder process = new ProcessBuilder();

		// java executor.execute Tutorial
		// java spawn multiple threads
		// Java - Creating Multiple Threads with a For Loop - just to check what we are
		// getting as Thread Value
		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 1; i <= 5; i++)
			executor.execute(new RunnableMethod(i));

		// environment() returns a string map view of this process builder's
		// environment. Whenever a process builder is created, the
		// environment is initialized to a copy of the current process environment
		Map<String, String> environment = process.environment();

		Set<String> myKeys = environment.keySet();
		println("================= Printing ProcessBuilder Environment Properties =================");
		for (String aKey : myKeys) {
			println(aKey + " \t==> " + environment.get(aKey));
		}

		// Set Directory
		File newDir = new File("~/ashah/Desktop");
		process.directory(newDir);

		// Get working directory. directory() returns this process builder's working
		// directory.
		File directory = process.directory();
		println("This is what we set as working directory: " + directory);
	}

	public static void println(String string) {
		System.out.println(string);
	}
}

// Runnable Class which we specified in executor.execute() method above
class RunnableMethod implements Runnable {
	public RunnableMethod(int i) {
		System.out.println(i);
	}

	// executor.execute() calls this method every time we call it.
	@Override
	public void run() {
		System.out.println("Running Overriding run() method...");
	}

}
