package com.loggar.system.jvm;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Date;

public class GetJVMTime {
	public static void main(String[] args) {
		RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
		long startTime = runtimeBean.getStartTime();
		Date startDate = new Date(startTime);

		System.out.println("Start Time in millisecond = " + startTime);
		System.out.println("Start Date = " + startDate);
	}
}
