package com.loggar.process.node;

public class RunNodeProcessNoWaitTest {
	public static void main(String[] args) {
		String[] arguments = { "node", "./dist/cmd-process/node-script/node-sample.1.js" };
		RunProcessNoWait.run(arguments);
	}
}
