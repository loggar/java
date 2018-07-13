package com.loggar.process.node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunNodeProcessWithOutputConsole {
	public static void main(String[] args) {
		ProcessBuilder builder = new ProcessBuilder("node", "./dist/cmd-process/node-script/node-sample.1.js");
		builder.redirectErrorStream(true);
		Process process;
		try {
			process = builder.start();
			watch(process);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void watch(final Process process) {
		new Thread() {
			public void run() {
				BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String line = null;
				try {
					while ((line = input.readLine()) != null) {
						System.out.println(line);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
}
