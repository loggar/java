package com.loggar.interfaces.default_methods;

import org.junit.jupiter.api.Test;

public class DefaultMethodDefinitionInInterfaceTest {
	@Test
	public void test() {
		DefaultMethodDefinitionInInterface test1 = new DefaultMethodDefinitionInInterfaceImpl_1();
		DefaultMethodDefinitionInInterface test2 = new DefaultMethodDefinitionInInterfaceImpl_2();
		
		System.out.println(test1.message());
		System.out.println(test2.message());
	}
}
