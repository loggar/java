package com.loggar.environments;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SystemProcessList {
	public static void main(String[] args) {
		try {
			String process;
			// getRuntime: Returns the runtime object associated with the current Java application.
			// exec: Executes the specified string command in a separate process.
			
			//Process p = Runtime.getRuntime().exec("ps -few"); // Unix
			//Process p = Runtime.getRuntime().exec("get-process"); //Powershell
			Process p = Runtime.getRuntime().exec("tasklist"); // windows cmd
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((process = input.readLine()) != null) {
				System.out.println(process); // <-- Print all Process here line by line
			}
			input.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
}
