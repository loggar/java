package com.loggar.process.cmd;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;

import com.loggar.system.OperatingSystemDependency;

public class ShellProcessBuilderEx {
	// This is preferred over the Runtime approach because we're able to customize some details.
	// For example we're able to:
	// - change the working directory our shell command is running in using builder.directory()
	// - set-up a custom key-value map as environment using builder.environment()
	// - redirect input and output streams to custom replacements
	// - inherit both of them to the streams of the current JVM process using builder.inheritIO()
	public static void main(String[] args) throws IOException, InterruptedException {
		ProcessBuilder builder = new ProcessBuilder();
		if (OperatingSystemDependency.isWindows()) {
			builder.command("cmd.exe", "/c", "dir");
		} else {
			builder.command("sh", "-c", "ls");
		}
		builder.directory(new File(System.getProperty("user.home")));
		Process process = builder.start();
		StreamConsumer streamGobbler = new StreamConsumer(process.getInputStream(), System.out::println);
		Executors.newSingleThreadExecutor().submit(streamGobbler);
		int exitCode = process.waitFor();
		assert exitCode == 0;
	}
}
