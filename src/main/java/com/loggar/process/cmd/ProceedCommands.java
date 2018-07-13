package com.loggar.process.cmd;

import java.util.List;

public interface ProceedCommand {
	boolean run(List<String> commands);
}
