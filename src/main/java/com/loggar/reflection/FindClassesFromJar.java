package com.loggar.reflection;

import java.io.FileInputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import org.json.JSONArray;
import org.json.JSONObject;

public class FindClassesFromJar {
	@SuppressWarnings("resource")
	public static JSONObject getClassNamesFromJar(String jarFileName) {
		JSONArray listofClasses = new JSONArray();
		JSONObject jsonObj = new JSONObject();
		try {
			JarInputStream fileJar = new JarInputStream(new FileInputStream(jarFileName));
			JarEntry jarEntry;

			while (true) {
				jarEntry = fileJar.getNextJarEntry();
				if (jarEntry == null) {
					break;
				}
				if ((jarEntry.getName().endsWith(".class"))) {
					String className = jarEntry.getName().replaceAll("/", "\\.");
					String myClass = className.substring(0, className.lastIndexOf('.'));
					listofClasses.put(myClass);
				}
			}
			jsonObj.put("Jar File Name", jarFileName);
			jsonObj.put("List of Class", listofClasses);
		} catch (Exception e) {
			System.out.println("Oops.. Encounter an issue while parsing jar" + e.toString());
		}
		return jsonObj;
	}

	public static void main(String[] args) {
		JSONObject myList = getClassNamesFromJar("./dist/reflection/commons-io-2.6.jar");
		System.out.println(myList);
	}
}
