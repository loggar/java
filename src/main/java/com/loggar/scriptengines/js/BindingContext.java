package com.loggar.scriptengines.js;

import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class BindingContext {
	public static void main(String[] args) throws Exception {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		Path p1 = Paths.get("./dist/scriptengines-js/example.js");
		engine.eval(new FileReader(p1.toString()));

		ScriptContext context = engine.getContext();
		// stores an object under the key `myKey` in the (engine scoped) context
		context.setAttribute("myKey", "x", ScriptContext.ENGINE_SCOPE);
		// retrieves the object with key `myKey` from (engine scoped) context
		context.getAttribute("myKey", ScriptContext.ENGINE_SCOPE);

		Bindings b = context.getBindings(ScriptContext.ENGINE_SCOPE);
		b.get("Object"); // gets ECMAScript "Object" constructor
		b.get("undefined"); // ECMAScript 'undefined' value
	}
}
