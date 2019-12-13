package com.loggar.effective.instantiation;

/**
 * Avoid using Class Finalizer on purpose of memory managing.
 * It is not even executed every time, does not help memory releasing.
 *
 */
public class _07_DoNotUseClassFinalize {
	
	/**
	 * Do not use this for releasing memory.
	 */
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}
}
