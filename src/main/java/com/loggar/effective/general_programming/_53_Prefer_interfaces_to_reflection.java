package com.loggar.effective.general_programming;

import java.util.Arrays;
import java.util.Set;

/**
 * Prefer interfaces to reflection
 *
 */
public class _53_Prefer_interfaces_to_reflection {
	/*
	 * The core reflection facility, java.lang.reflect, offers programmatic access
	 * to information about loaded classes. Given a Class object, you can obtain
	 * Constructor, Method, and Field instances representing the constructors,
	 * methods, and fields of the class represented by the Class instance. These
	 * objects provide programmatic access to the class’s member names, field types,
	 * method signatures, and so on.
	 * 
	 * Moreover, Constructor, Method, and Field instances let you manipulate their
	 * underlying counterparts reflectively: you can construct instances, invoke
	 * methods, and access fields of the underlying class by invoking methods on the
	 * Constructor, Method, and Field instances. For example, ethod.invoke lets you
	 * invoke any method on any object of any class (subject to the usual security
	 * constraints). Reflection allows one class to use another, even if the latter
	 * class did not exist when the former was compiled. This power, however, comes
	 * at a price:
	 * 
	 * • You lose all the benefits of compile-time type checking, including
	 * exception checking. If a program attempts to invoke a nonexistent or
	 * inaccessible method reflectively, it will fail at runtime unless you’ve taken
	 * special precautions.
	 * 
	 * • The code required to perform reflective access is clumsy and verbose. It is
	 * tedious to write and difficult to read.
	 * 
	 * • Performance suffers. Reflective method invocation is much slower than
	 * normal method invocation. Exactly how much slower is hard to say, because
	 * there are so many factors at work. On my machine, the speed difference can be
	 * as small as a factor of two or as large as a factor of fifty.
	 * 
	 * The core reflection facility was originally designed for component-based
	 * application builder tools. Such tools generally load classes on demand and
	 * use reflection to find out what methods and constructors they support. The
	 * tools let their users interactively construct applications that access these
	 * classes, but the generated applications access the classes normally, not
	 * reflectively. Reflection is used only at design time. As a rule, objects
	 * should not be accessed reflectively in normal applications at runtime.
	 * 
	 * You can obtain many of the benefits of reflection while incurring few of its
	 * costs by using it only in a very limited form. For many programs that must
	 * use a class that is unavailable at compile time, there exists at compile time
	 * an appropriate interface or superclass by which to refer to the class (Item
	 * 52). If this is the case, you can create instances reflectively and access
	 * them normally via their interface or superclass. If the appropriate
	 * constructor has no parameters, then you don’t even need to use
	 * java.lang.reflect; the Class.newInstance method provides the required
	 * functionality.
	 * 
	 * For example, here’s a program that creates a Set<String> instance whose class
	 * is specified by the first command line argument.
	 * 
	 * The order in which these arguments are printed, however, depends on the class
	 * specified in the first argument. If you specify java.util.HashSet, they’re
	 * printed in apparently random order; if you specify java.util.TreeSet, they’re
	 * printed in alphabetical order, as the elements in a TreeSet are sorted:
	 */

	/**
	 * Reflective instantiation with interface access.
	 */
	@SuppressWarnings("unchecked")
	public void reflective_instantiation(String[] args) {

		// Translate the class name into a Class object
		Class<?> c = null;

		try {
			c = Class.forName(args[0]);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Instantiate the class
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

	/*
	 * This example demonstrates two disadvantages of reflection. First, the example
	 * can generate three runtime errors, all of which would have been compile-time
	 * errors if reflective instantiation were not used. Second, it takes twenty
	 * lines of tedious code to generate an instance of the class from its name,
	 * whereas a constructor invocation would fit neatly on a single line. These
	 * disadvantages are, however, restricted to the part of the program that
	 * instantiates the object. Once instantiated, it is indistinguishable from any
	 * other Set instance. In a real program, the great bulk of the code is thus
	 * unaffected by this limited use of reflection.
	 * 
	 * If you try compiling the program, you’ll get the following error message:
	 * 
	 * Note: SetEx.java uses unchecked or unsafe operations. Note: Recompile with
	 * -Xlint:unchecked for details.
	 * 
	 * This warning concerns the program’s use of generic types, but it does not
	 * indicate a real problem. To learn the best way to suppress the warning, see
	 * Item 24. Another tangential issue that deserves note is this program’s use of
	 * System. exit. It is rarely appropriate to call this method, which terminates
	 * the entire VM. It is, however, appropriate for abnormal termination of a
	 * command line utility.
	 * 
	 * In summary, reflection is a powerful facility that is required for certain
	 * sophisticated system programming tasks, but it has many disadvantages. If you
	 * are writing a program that has to work with classes unknown at compile time,
	 * you should, if at all possible, use reflection only to instantiate objects,
	 * and access the objects using some interface or superclass that is known at
	 * compile time.
	 * 
	 */
}
