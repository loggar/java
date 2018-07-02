package com.loggar.cmd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunCommandsConsole implements RunCommands {
	private static final Logger logger = LoggerFactory.getLogger(RunCommandsConsole.class);

	@Override
	public boolean run(List<String> commands) {
		if (commands == null || commands.size() < 1) return false;
		try {
			ProcessBuilder processBuilder = new ProcessBuilder("cmd");
			processBuilder.redirectErrorStream(true);
			Process process = processBuilder.start();
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			for (String command : commands) {
				logger.info("process next command : {}", command);
				writer.write(command + "\n");
				writer.flush();
			}
			writer.write("exit" + "\n");
			writer.flush();
			BufferedReader std = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String outputLine = null;
			while ((outputLine = std.readLine()) != null) {
				if (!Pattern.matches("^[0-9]{1,7}\\/[0-9]{1,7}.*", outputLine)) logger.info("{}", outputLine);
			}
			process.waitFor();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
