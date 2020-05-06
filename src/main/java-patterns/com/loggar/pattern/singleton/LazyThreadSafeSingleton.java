package com.loggar.pattern.singleton;

/**
 * Lazy Creation of Singleton ThreadSafe Instance without Using Synchronized Keyword
 * 
 */
public class LazyThreadSafeSingleton {
	private LazyThreadSafeSingleton() {
	}

	private static class HoldInstance {
		private static final LazyThreadSafeSingleton INSTANCE = new LazyThreadSafeSingleton();
	}

	public static LazyThreadSafeSingleton getInstance() {
		return HoldInstance.INSTANCE;
	}
}
