package com.loggar.annotations.feedback;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RunAtStartupTest {
	public static void main(String[] args) throws Exception {
		List<Class<?>> packageClasses = getAllClassesInPackageContaining(RunAtStartupTest.class);

		List<RunAtStartupData> registrations = new ArrayList<>();

		for (Class<?> clazz : packageClasses) {
			RunAtStartup runAtStartup = clazz.getAnnotation(RunAtStartup.class);
			if (runAtStartup == null)
				continue;

			Object instance = clazz.newInstance();
			Method method = clazz.getMethod(runAtStartup.method());

			registrations.add(new RunAtStartupData(instance, method, runAtStartup.priority()));
		}

		Collections.sort(registrations, Comparator.<RunAtStartupData>comparingInt(x -> x.priority).reversed());

		for (RunAtStartupData registration : registrations) {
			registration.callMethod();
		}
	}

	private static class RunAtStartupData {
		Object object;
		Method method;
		int priority;

		public RunAtStartupData(Object object, Method method, int priority) {
			this.object = object;
			this.method = method;
			this.priority = priority;
		}

		public void callMethod() throws Exception {
			method.invoke(object);
		}
	}

	static List<Class<?>> getAllClassesInPackageContaining(Class<?> clazz) throws IOException {
		String clazzPath = clazz.getResource("./").getPath();
		clazzPath = clazzPath.substring(1, clazzPath.length()); // if windows system.
		
		Path packagePath = Paths.get(clazzPath).getParent();

		String clazzPackageName = clazz.getPackage().getName();
		final List<Class<?>> packageClasses = new ArrayList<>();

		Files.walkFileTree(packagePath, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				String filename = file.getName(file.getNameCount() - 1).toString();

				if (filename.endsWith(".class")) {
					String className = filename.replace(".class", "");

					try {
						Class<?> loadedClazz = Class.forName(clazzPackageName + "." + className);
						packageClasses.add(loadedClazz);
					} catch (ClassNotFoundException e) {
						System.err.println("class not found: " + e.getMessage());
					}
				}

				return super.visitFile(file, attrs);
			}
		});

		return packageClasses;
	}

}
