package com.loggar.datetimes;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class TimestampUtc {
	public static void main(String[] args) {
		OffsetDateTime utc = OffsetDateTime.now(ZoneOffset.UTC);
		System.out.println(utc);
	}
}
