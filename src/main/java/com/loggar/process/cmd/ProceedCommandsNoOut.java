package com.loggar.process.cmd;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.List;

public class ProceedCommandNoOut implements ProceedCommand {
	@Override
	public boolean run(List<String> commands) {
		if (commands == null || commands.size() < 1)
			return false;
		try {
			ProcessBuilder processBuilder = new ProcessBuilder("cmd");
			processBuilder.redirectErrorStream(true);
			Process process = processBuilder.start();
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			for (String command : commands) {
				writer.write(command + "\n");
				writer.flush();
			}
			writer.write("exit" + "\n");
			writer.flush();
			process.waitFor(); // wait until this process end.
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
