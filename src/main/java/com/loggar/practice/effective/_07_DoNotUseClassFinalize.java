package com.loggar.practice.effective;

/**
 * 메모리 관리를 위한 목적의 class finalizer 메소드를 피하자, 하등 도움이 되지 않으며 실행이 반드시 보장되지도 않는다.
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
