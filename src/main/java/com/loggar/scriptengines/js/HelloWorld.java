package com.loggar.scriptengines.js;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class HelloWorld {
	public static void main(String[] args) {
		ScriptEngineManager m = new ScriptEngineManager(); // Sets up Nashorn JavaScript Engine
		ScriptEngine e = m.getEngineByExtension("js"); // Nashorn JavaScript syntax.
		try {
			e.eval("print ('Hello, ')");
		} catch (ScriptException e1) {
			e1.printStackTrace();
		}
		
		Path p1 = Paths.get("./dist/scriptengines-js/world.js");
		try {
			e.eval(new FileReader(p1.toString()));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (ScriptException e1) {
			e1.printStackTrace();
		}
	}
}
