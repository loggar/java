package com.loggar.process.node;

import java.io.IOException;

public class RunNodeProcessNoWait {
	public static void main(String[] args) {
		ProcessBuilder builder = new ProcessBuilder("node", "./dist/cmd-process/node-script/node-sample.1.js");
		builder.redirectErrorStream(true);
		try {
			builder.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
