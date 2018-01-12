package com.loggar.annotations;

@RunAtStartup(priority = 100, method = "initialize")
public class StartupClassTest2 {
	public void run() {
		throw new IllegalStateException("This method should not be called");
	}

	public void initialize() {
		System.out.println("Class 2 initialized by StartupClassTest2.initialize()");
	}
}
