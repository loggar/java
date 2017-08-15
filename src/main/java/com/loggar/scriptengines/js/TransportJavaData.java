package com.loggar.scriptengines.js;

import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Test;

public class TransportJavaData {
	@Test
	public void accesJavaVariables() throws ScriptException {
		ScriptEngineManager m = new ScriptEngineManager();
		ScriptEngine e = m.getEngineByExtension("js");
		String world = "Gliese 581 c";
		e.put("nameKey", world);
		e.eval("var w = nameKey");
		e.eval("print(w)");
	}
	
	@Test
	public void accesJavaObjects() throws ScriptException {
		ScriptEngineManager m = new ScriptEngineManager();
		ScriptEngine e = m.getEngineByExtension("js");
		List<String> worldList = new ArrayList<>();
		worldList.add ("Earth");
		worldList.add ("Mars");
		e.put("nameKey", worldList);
		e.eval("var w = nameKey.toArray();");
		e.eval(" nameKey.add (\"Gliese 581 c\")");
		System.out.println(worldList);
	}
}
