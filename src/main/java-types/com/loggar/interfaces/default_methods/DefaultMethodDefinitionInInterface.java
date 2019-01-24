package com.loggar.interfaces.default_methods;

/*
 * now we can define method in interface with default keyword.
 */
public interface DefaultMethodDefinitionInInterface {
	void call();
	
	default String message() {
		return "new messgae from interface";
	}
	
	/*
	 * [충돌문제]
	 * 기존의 java 의 multiple implementation of interfaces 의 경우 클래스가 모든 method 를 구현해야 했으므로 충돌 문제가 없었으나
	 * 이제 interface 에서 default 로 정의된 메소드 떄문에 class 에서 선택의 문제가 생겼다.
	 * 이를 방지하기 위해 두 인터페이스에서 같은 signature 를 갖는 메소드를 default 로 정의하고 있는경우, 이 두 인터페이스를 구현하는 클래스는 여전히 반드시 그 method 를 구현햐여 충돌을 방지해야한다.
	 */
	
	/*
	 * [Java Third Rule]
	 * 클래스 C 가 인터페이스 I 를 구현하고, 동시에 클래스 A 를 상속할때, 
	 * 이 I, A 에 같은 signature 의 메소드가 정의 되어 있을경우, 클래스 C 는 클래스 A 의 method definition 을 따른다.
	 */
	
	/*
	 * 여전히 클래스는 상속시 상위 클래스의 메소드를 재정의 할 수 있으며, Object 클래스의 메소드 역시 재정의 할 수 있다.
	 * deafult method definition in interface 의 도입으로 인한 혼란을 방지하기 위해, interface 는 Java Object 클래스에 정의되어있는 method 를 정의 할 수 없다.
	 */
}
