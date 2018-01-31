package com.loggar.statements;

/*
 * In the situations where the next value of the variable is dependent on the
 * previous value, there is a chance that multiple threads reading and writing
 * the variable may go out of sync, due to a time gap between the reading and
 * writing back to the main memory.
 */
public class Keyword_Volatile {
	private volatile int count = 0;

	public void increamentCount() {
		count++;
	}

	public int getCount() {
		return count;
	}
}
/*
 * With no synchronization here, a typical race condition can occur. Basically,
 * with an execution gap between incrementing and writing it to main memory,
 * other threads might see a value of 0, and try to write it to main memory.
 * 
 * The race condition can of course also be avoided with the use of the Java
 * provided atomic data types like AtomicInt or AtomicLong.
 */

/*
 * Volatile and Thread Synchronization
 * 
 * For all the multithreaded applications, we need to ensure a couple of rules
 * for a consistent behavior:
 * 
 * Mutual Exclusion – only one thread executes a critical section at a time
 * Visibility – changes made by one thread to the shared data, are visible to
 * other threads to maintain a data consistency Synchronized methods and blocks
 * provide both of the above properties, at the cost of performance of the
 * application.
 * 
 * Volatile is quite a useful primitive because it can help ensure the
 * visibility aspect of the data change, without, of course, providing the
 * mutual exclusion. Thus, it’s useful in the places where we are ok with
 * multiple threads are executing a block of code in parallel but we need to
 * ensure the visibility property.
 */

/*
 * Happens-Before Guarantee
 * 
 * Starting with Java 5, the volatile keyword also provides additional
 * capabilities which ensure that values of all the variables including
 * non-volatile variables are written to the main memory along with the Volatile
 * write operation.
 * 
 * This is called Happens-Before, as it gives a visibility of all variables to
 * another reading thread. Also, JVM doesn’t reorder the reading and writing
 * instructions of volatile variables.
 * 
 * 
 * Thread 1 object.aNonValitileVariable = 1; object.aVolatileVariable = 100; //
 * volatile write
 * 
 * Thread 2: int aNonValitileVariable = object.aNonValitileVariable; int
 * aVolatileVariable = object.aVolatileVariable;
 * 
 * In this case, when Thread 1 has written the value of aVolatileVariable then
 * the value of aNonValitileVariable is also written to the main memory. And
 * even though it’s not a volatile variable, it is exhibiting a volatile
 * behavior.
 * 
 * By making use of these semantics, we can define only a few of the variables
 * in our class as volatile and optimize the visibility guarantee.
 */
