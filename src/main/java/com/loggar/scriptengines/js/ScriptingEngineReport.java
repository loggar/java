package com.loggar.scriptengines.js;

import java.util.List;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

public class ScriptingEngineReport {
	public static void main(String[] args) {
		ScriptEngineManager m = new ScriptEngineManager();
		List<ScriptEngineFactory> s = m.getEngineFactories();
		// Iterate through list of factories
		for (ScriptEngineFactory f : s) {
			// Release name and version
			String en = f.getEngineName();
			String ev = f.getEngineVersion();
			System.out.println("Engine: " + en + " " + ev);
			// Language name and version
			String ln = f.getLanguageName();
			String lv = f.getLanguageVersion();
			System.out.println("Language: " + ln + " " + lv);
			// Extensions
			List<String> l = f.getExtensions();
			for (String x : l) {
				System.out.println("Extensions: " + x);
			}
		}
	}
}
