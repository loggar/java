package com.loggar.process.cmd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.regex.Pattern;

public class ProceedCommandsConsoleOut implements ProceedCommands {
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
				System.out.println("process next command : " + command);
				writer.write(command + "\n");
				writer.flush();
			}
			writer.write("exit" + "\n");
			writer.flush();
			BufferedReader std = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String outputLine = null;
			while ((outputLine = std.readLine()) != null) {
				if (!Pattern.matches("^[0-9]{1,7}\\/[0-9]{1,7}.*", outputLine))
					System.out.println(outputLine);
			}
			process.waitFor(); // wait until this process end.
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
