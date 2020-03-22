package com.loggar.process.cmd;

import java.io.IOException;
import java.util.concurrent.Executors;

import com.loggar.system.OperatingSystemDependency;

public class ShellRuntimeExecEx {
	// A method-call to Runtime.exec() is a simple, not yet customizable, way to spawn a new sub-process.
	// In the following example we will request a directory-listing of a users home-directory and printing it to the console:
	public static void main(String[] args) throws IOException, InterruptedException {
		String homeDirectory = System.getProperty("user.home");
		Process process;

		if (OperatingSystemDependency.isWindows()) {
			process = Runtime.getRuntime().exec(String.format("cmd.exe /c dir %s", homeDirectory));
		} else {
			process = Runtime.getRuntime().exec(String.format("sh -c ls %s", homeDirectory));
		}
		StreamConsumer streamGobbler = new StreamConsumer(process.getInputStream(), System.out::println);
		Executors.newSingleThreadExecutor().submit(streamGobbler);
		int exitCode = process.waitFor();
		assert exitCode == 0;
	}
}
