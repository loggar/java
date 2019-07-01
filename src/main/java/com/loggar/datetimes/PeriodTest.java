package com.loggar.datetimes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.time.Period;

import org.junit.jupiter.api.Test;

public class PeriodTest {
	@Test
	public void period() {
		Period p1 = Period.parse("P10Y5M2D");
		System.out.println(p1);

		Period p2 = Period.of(5, 10, 40);
		System.out.println(p2);

		p2 = p2.plusYears(100);
		p2 = p2.plusMonths(5).minusDays(30);
		System.out.println(p2);

	}

	@Test
	public void period_1() {
		LocalDate startDate = LocalDate.of(2015, 2, 20);
		LocalDate endDate = LocalDate.of(2017, 1, 15);

		Period period = Period.between(startDate, endDate);

		System.out.println("Years:" + period.getYears() + " months:" + period.getMonths() + " days:" + period.getDays());

		assertFalse(period.isNegative());
	}

	@Test
	public void period_2() {
		Period fromUnits = Period.of(3, 10, 10);
		Period fromDays = Period.ofDays(50);
		Period fromMonths = Period.ofMonths(5);
		Period fromYears = Period.ofYears(10);
		Period fromWeeks = Period.ofWeeks(40);

		System.out.println(fromUnits.getDays());
		System.out.println(fromDays.getDays());
		System.out.println(fromMonths.getDays());
		System.out.println(fromYears.getDays());
		System.out.println(fromWeeks.getDays());

		assertEquals(10, fromUnits.getDays());
		assertEquals(50, fromDays.getDays());
		assertEquals(0, fromMonths.getDays());
		assertEquals(0, fromYears.getDays());
		assertEquals(280, fromWeeks.getDays());

	}

	@Test
	public void period_3() {
		Period fromCharYears = Period.parse("P2Y");
		assertEquals(2, fromCharYears.getYears());

		Period fromCharUnits = Period.parse("P2Y3M5D");
		assertEquals(5, fromCharUnits.getDays());

		Period period = Period.ofMonths(5);
		System.out.println(period.plusDays(50).getDays());
		System.out.println(period.minusMonths(2).getMonths());

		assertEquals(50, period.plusDays(50).getDays());
		assertEquals(3, period.minusMonths(2).getMonths());
	}
}
