package com.loggar.concurrents;

import java.util.Calendar;

public class AlwaysRunningProgram {
	public static void main(String args[]) {
		AlwaysRunningProgram object = new AlwaysRunningProgram();
		object.waitMethod();
	}

	private synchronized void waitMethod() {
		while (true) {
			System.out.println("always running program ==> " + Calendar.getInstance().getTime());
			try {
				this.wait(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
