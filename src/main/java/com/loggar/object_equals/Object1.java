package com.loggar.object_equals;

public class Object1 extends Object {
	int valueA = 0;
	String valueB;
	long valueC;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + valueA;
		result = prime * result + ((valueB == null) ? 0 : valueB.hashCode());
		result = prime * result + (int) (valueC ^ (valueC >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Object1 other = (Object1) obj;
		if (this.hashCode() != other.hashCode())
			return false;
		return true;
	}

	public static void main(String[] args) {
		int i1 = 7;
		int i2 = 7;

		System.out.println(i1 == i2);

		String a = "abc";
		String b = "abc";

		a = "abcd";

		System.out.println(a == b);

		Object1 o1 = new Object1();
		Object1 o2 = new Object1();

		System.out.println(o1 == o2);
		System.out.println(o1.equals(o2));
	}

}
