package com.loggar.scriptengines.js;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class InvokingMethodsOfScript {
	public static void main(String[] args) throws Exception {
		ScriptEngineManager m = new ScriptEngineManager();
		ScriptEngine e = m.getEngineByExtension("js");
		e.eval("function greet(message) {" + "print(message)" + "}");
		
		Invocable i = (Invocable) e;
		i.invokeFunction("greet", "Greetings from Mars!");
	}
}
