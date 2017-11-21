package com.loggar.generics.sample;

/**
 * Constructors of generic classes do not require generic type parameters as
 * arguments:
 * 
 * @author loggar.lee
 *
 * @param <E>
 */
public class ConstuctorsWithGeneric<E> {
	public ConstuctorsWithGeneric() {
		System.out.println("ConstuctorsWithGeneric()");
	}

	public ConstuctorsWithGeneric(String s) {
		System.out.println("ConstuctorsWithGeneric(String)");
	}

	public static void main(String[] args) {
		ConstuctorsWithGeneric<String> b1 = new ConstuctorsWithGeneric<String>();
		ConstuctorsWithGeneric<String> b2 = new ConstuctorsWithGeneric<String>("Joan Marie");
		
		System.out.println(b1);
		System.out.println(b2);
	}
}
