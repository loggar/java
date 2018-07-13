package com.loggar.process.cmd;

import java.util.ArrayList;
import java.util.List;

/**
 * build and deploy
 * 
 * excution(console-window) java RunMavenBuild.java [product | dev | local]
 * (default local)
 *
 */
public class RunMavenBuild {
	private static final String PATH_LOCAL_MAVEN = "C:\\_dev\\maven\\apache-maven-3.3.9\\bin\\";
	private static final String PATH_LOCAL_PROJECT = "C:\\Users\\webnl\\Documents\\_workspace_loggar\\loggar_java";

	public static List<String> getCommandList() {
		String command = "mvn";
		String option_d = " -Dmaven.test.skip=true";
		String targets = " clean compile war:inplace";
		String target_deploy = " tomcat7:redeploy";
		String mvn_profile_1 = "profile_1";

		List<String> commands = new ArrayList<>();

		commands.add("cd " + PATH_LOCAL_PROJECT);
		commands.add(PATH_LOCAL_MAVEN + command + option_d + " -P" + mvn_profile_1 + targets + target_deploy);
		return commands;
	}

	public static void main(String[] args) {
		ProceedCommandsTimeDecorator.run(new ProceedCommandsConsoleOut(), getCommandList());
	}
}
