package com.loggar.generics.sample;

public class GenericMethodsInRawTypes {
	public static <E> boolean add(E e) { return true;}
	public static <E> E peek() {return null; }
	
	public static void main(String[] args) {
		boolean b = GenericMethodsInRawTypes.<String>add("White Carnation");
		String s = GenericMethodsInRawTypes.<String>peek();
		
		System.out.println(b);
		System.out.println(s);
	}
	
}
