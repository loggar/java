package com.loggar.practice.effective;

import java.util.Calendar;

/**
 * 불필요한 객체생성을 하지 말자.
 * 
 * ex) String a = new String("sdfs");  <- 이 구문은 매우 비효율적이다.
 * @author loggar.lee
 *
 */
public class _05_AvoidUnnecessaryInstantiation {
	private static Calendar cal;
	
	static {
		cal = Calendar.getInstance();
	}
	
	/**
	 * 메소드가 수행될 때마다 Calendar 을 생성하는 코드보다 아래 방법은 매우 자원효율적이고, 빠르다.
	 * @return
	 */
	public String doSomethingWithCal() {
		return cal.toString();
	}
}
