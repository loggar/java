package com.loggar.annotations.feedback;

@RunAtStartup(priority = 10)
public class StartupClassTest1 {
	public void run() {
		System.out.println("Class 1 initialized by StartupClassTest1.run()");
	}
}
