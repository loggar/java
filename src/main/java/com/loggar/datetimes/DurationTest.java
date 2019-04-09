package com.loggar.datetimes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

public class DurationTest {
	@Test
	public void duration() {
		Duration d1 = Duration.parse("P2DT3H4M1.1S");
		System.out.println(d1);

		Duration d3 = Duration.ofDays(8);
		d3 = d3.plusHours(3);
		d3 = d3.plusMinutes(30);
		d3 = d3.plusSeconds(55).minusNanos(300);

		System.out.println(d3);

		Instant birth = Instant.parse("1967-09-15T10:30:00Z");
		Instant current = Instant.now();
		Duration d4 = Duration.between(birth, current);
		System.out.print("Days alive: " + d4.toDays());
	}

	@Test
	public void duration_1() {
		Instant start = Instant.parse("2017-10-03T10:15:30.00Z");
		Instant end = Instant.parse("2017-10-03T10:16:30.00Z");

		Duration duration = Duration.between(start, end);

		assertEquals(60, duration.getSeconds());
		assertFalse(duration.isNegative());
	}

	@Test
	public void duration_2() {
		LocalTime start = LocalTime.of(1, 20, 25, 1024);
		LocalTime end = LocalTime.of(3, 22, 27, 1544);

		System.out.println(Duration.between(start, end).getSeconds());

		Duration fromDays = Duration.ofDays(1);

		assertEquals(86400, fromDays.getSeconds());

		Duration fromMinutes = Duration.ofMinutes(60);

		assertEquals(1, fromMinutes.toHours());
	}

	@Test
	public void duration_3() {
		Instant start = Instant.parse("2017-10-03T10:15:30.00Z");
		Instant end = Instant.parse("2017-10-03T10:16:30.00Z");

		Duration duration = Duration.between(start, end);

		assertEquals(120, duration.plusSeconds(60).getSeconds());
		assertEquals(30, duration.minusSeconds(30).getSeconds());

		assertEquals(120, duration.plus(60, ChronoUnit.SECONDS).getSeconds());
		assertEquals(30, duration.minus(30, ChronoUnit.SECONDS).getSeconds());
	}
}
