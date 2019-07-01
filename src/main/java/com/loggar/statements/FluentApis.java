package com.loggar.statements;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

import org.junit.jupiter.api.Test;

public class FluentApis {
	@Test
	public void fluentApiModuleSample_1() {
		StringBuilder sb = new StringBuilder("abcdefg hijklmn");

		// method chaining
		sb.delete(10, 11).append("st").reverse();

		System.out.println(sb);
	}

	@Test
	public void fluentApiModuleSample_2() {
		LocalDateTime ldt1 = LocalDateTime.now();
		System.out.println(ldt1);

		// static method with method chaining
		LocalDateTime ldt2 = LocalDateTime.now().withDayOfMonth(Calendar.TUESDAY).withYear(1981).plusWeeks(2).minus(3, ChronoUnit.HOURS);
		System.out.println(ldt2);

	}
}
