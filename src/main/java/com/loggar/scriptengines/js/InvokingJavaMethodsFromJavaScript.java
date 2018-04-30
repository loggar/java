package com.loggar.scriptengines.js;

import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class InvokingJavaMethodsFromJavaScript {
	public static void main(String[] args) throws Exception {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		Path p1 = Paths.get("./dist/scriptengines-js/invokingJavaMethodsFromJavaScript.js");
		engine.eval(new FileReader(p1.toString()));

		// cast the script engine to an invocable instance
		Invocable invocable = (Invocable) engine;

		Object result = invocable.invokeFunction("sayHello", "John Doe");
		System.out.println(result);
		System.out.println(result.getClass());
	}
}
