package com.loggar.concurrents.threads;

public class JavaThreadPriority extends Thread {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		JavaThreadPriority crunchThread1 = new JavaThreadPriority();
		JavaThreadPriority crunchThread2 = new JavaThreadPriority();

		System.out.println("crunchThread1 thread default priority : " + crunchThread1.getPriority());
		System.out.println("crunchThread2 thread default priority : " + crunchThread2.getPriority());

		// We are changing Priorities for threads
		crunchThread1.setPriority(7);
		crunchThread2.setPriority(9);

		System.out.println("\ncrunchThread1 thread updated priority : " + crunchThread1.getPriority());
		System.out.println("crunchThread2 thread updated priority : " + crunchThread2.getPriority());

		System.out.println("\nCurrent Thread Name: " + Thread.currentThread().getName());
		System.out.println("Main thread default priority : " + Thread.currentThread().getPriority());

		Thread.currentThread().setPriority(2);
		System.out.println("Main thread new priority : " + Thread.currentThread().getPriority());

		// Creating Child Thread.. Child Thread gets same priority as parent thread
		JavaThreadPriority crunchChildThread = new JavaThreadPriority();
		System.out.println("Child thread priority same as Main thread: " + crunchChildThread.getPriority());

		// More Thread Operations

		System.out.println("\n================= Let's work on all Thread Operations =================");
		// Returns the identifier of this Thread.
		System.out.println("- getId() : " + crunchChildThread.getId());

		// Returns an estimate of the number of active threads in the current thread's
		// thread group and its subgroups.
		System.out.println("- activeCount() : " + crunchChildThread.activeCount());

		// Returns the runtime class of this Object.
		System.out.println("- getClass() : " + crunchChildThread.getClass());

		// Returns the context ClassLoader for this Thread.
		System.out.println("- getContextClassLoader() : " + crunchChildThread.getContextClassLoader());

		// Returns an array of stack trace elements representing the stack dump of this
		// thread.
		System.out.println("- getStackTrace() : " + crunchChildThread.getStackTrace());

		// Returns the state of this thread.
		System.out.println("- getState() : " + crunchChildThread.getState());

		// Returns the thread group to which this thread belongs.
		System.out.println("- getThreadGroup() : " + crunchChildThread.getThreadGroup());

		// Returns a map of stack traces for all live threads.
		System.out.println("- getAllStackTraces() : " + crunchChildThread.getAllStackTraces());

		// True if this thread is alive.
		System.out.println("- isAlive() : " + crunchChildThread.isAlive());

		// True if thread is a daemon thread
		System.out.println("- isDaemon() : " + crunchChildThread.isDaemon());

		// Tests whether this thread has been interrupted.
		System.out.println("- isInterrupted() : " + crunchChildThread.isInterrupted());

	}

	@Override
	public void run() {
		System.out.println("Inside run method");
	}
}
