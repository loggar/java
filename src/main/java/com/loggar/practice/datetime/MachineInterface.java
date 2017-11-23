package com.loggar.practice.datetime;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

import org.junit.Test;

public class MachineInterface {
	@Test
	public void instant_test() {
		Instant i = Instant.now();
		System.out.println("Machine: " + i.toEpochMilli());
		System.out.println("Human: " + i);
	}
	
	@Test
	public void clock_test() {
		Clock clock1 = Clock.systemUTC();
		Instant i1 = Instant.now(clock1);
		System.out.println(i1);
		
		ZoneId zid = ZoneId.of("Europe/Vienna");
		Clock clock2 = Clock.system(zid);
		Instant i2 = Instant.now(clock2);
		System.out.println(i2);
	}
}
