package com.loggar.effective;

import java.util.Arrays;
import java.util.Set;

public class _17_Reflection_prefer_interface {
	/**
	 * Reflective instantiation with interface access.
	 */
	@SuppressWarnings("unchecked")
	public void reflective_instantiation(String[] args) {
		
		//Translate the class name into a Class object
		Class<?> c = null;
		
		try {
			c = Class.forName(args[0]);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//Instantiate the class
		Set<String> s = null;
		
		try {
			s = (Set<String>) c.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		// Exercise the set
		s.addAll(Arrays.asList(args).subList(1, args.length));
		
		System.out.println(s);
	}
}
