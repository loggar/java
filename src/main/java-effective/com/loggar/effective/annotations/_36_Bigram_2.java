package com.loggar.effective.annotations;

import java.util.HashSet;
import java.util.Set;

/**
 * Consistently use the Override annotation
 *
 */
// Can you spot the bug?
public class _36_Bigram_2 {
	private final char first;
	private final char second;

	public _36_Bigram_2(char first, char second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof _36_Bigram_2))
			return false;
		_36_Bigram_2 b = (_36_Bigram_2) o;
		return b.first == first && b.second == second;
	}

	public int hashCode() {
		return 31 * first + second;
	}

	public static void main(String[] args) {
		Set<_36_Bigram_2> s = new HashSet<_36_Bigram_2>();
		for (int i = 0; i < 10; i++)
			for (char ch = 'a'; ch <= 'z'; ch++)
				s.add(new _36_Bigram_2(ch, ch));
		System.out.println(s.size());
	}
}
/*
 * Therefore, you should use the Override annotation on every method declaration
 * that you believe to override a superclass declaration. There is one minor
 * exception to this rule. If you are writing a class that is not labeled
 * abstract, and you believe that it overrides an abstract method, you needn’t
 * bother putting the Override annotation on that method. In a class that is not
 * declared abstract, the compiler will emit an error message if you fail to
 * override an abstract superclass method.
 * 
 * Modern IDEs provide another reason to use the Override annotation
 * consistently. Such IDEs have automated checks known as code inspections. If
 * you enable the appropriate code inspection, the IDE will generate a warning
 * if you have a method that doesn’t have an Override annotation but does
 * override a superclass method.
 * 
 * If you are using release 1.6 or a later release, the Override annotation
 * provides even more help in finding bugs. In release 1.6, it became legal to
 * use the Override annotation on method declarations that override declarations
 * from interfaces as well as classes. In a concrete class that is declared to
 * implement an interface, you needn’t annotate methods that you believe to
 * override interface methods, because the compiler will emit an error message
 * if your class fails to implement every interface method. Again, you may
 * choose to include these annotations simply to draw attention to interface
 * methods, but it isn’t strictly necessary.
 * 
 * For example, the Set interface adds no new methods to the Collection
 * interface, so it should include Override annotations on all of its method
 * declarations, to ensure that it does not accidentally add any new methods to
 * the Collection interface.
 * 
 * In summary, the compiler can protect you from a great many errors if you use
 * the Override annotation on every method declaration that you believe to
 * override a supertype declaration, with one exception. In concrete classes,
 * you need not annotate methods that you believe to override abstract method
 * declarations (though it is not harmful to do so).
 */