package com.loggar.process.cmd;

import java.util.ArrayList;
import java.util.List;

public class RunNodeApp {
	private static final String PATH_LOCAL_APP = "./dist/cmd-process/node-script";

	private static List<String> getCommandList() {
		List<String> commands = new ArrayList<>();

		commands.add("cd " + PATH_LOCAL_APP);
		commands.add("node ./node-sample.1.js");
		return commands;
	}

	public static void main(String[] args) {
		ProceedCommandsTimeDecorator.run(new ProceedCommandsNoOut(), getCommandList());
	}
}
