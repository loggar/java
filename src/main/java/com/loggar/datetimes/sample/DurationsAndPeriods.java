package com.loggar.datetimes.sample;

import java.time.Duration;
import java.time.Instant;
import java.time.Period;

import org.junit.Test;

public class DurationsAndPeriods {
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
	public void period() {
		Period p1 = Period.parse("P10Y5M2D");
		System.out.println(p1);
		
		Period p2 = Period.of(5, 10, 40);
		System.out.println(p2);
		
		p2 = p2.plusYears(100);
		p2 = p2.plusMonths(5).minusDays(30);
		System.out.println(p2);
		
	}
}
