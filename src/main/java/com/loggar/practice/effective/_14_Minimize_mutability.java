package com.loggar.practice.effective;

/**
 * Most of cases, classes should be immutable unless there is a very good reason to make them mutable.
 * 
 * If a class cannot be made immutable, limit its mutability as much as possible.
 * make every field final unless there is a compelling reason to make it nonfinal.
 * 
 * @author loggar.lee
 *
 */
public class _14_Minimize_mutability {
	public static void main(String[] args) {
		Complex c1 = Complex.valueOf(1.1, 2.2);
		Complex c2 = Complex.valueOf(3.3, 4.4);
		Complex c3 = c1.add(c2);
		Complex c4 = c1.add(c2);
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println("(c3 == c4) : " + (c3 == c4));
		System.out.println("c3.equals(c4) : " + c3.equals(c4));
	}
	
	/**
	 * every instance of this class is immutable.
	 * @author loggar.lee
	 *
	 */
	static class Complex {
		/*
		 * final fields make class immutable.
		 */
		private final double re;
		private final double im;
		
		/*
		 * private constructor makes class not-inherited.
		 */
		private Complex(double re, double im) {
			this.re = re;
			this.im = im;
		}
		
		/*
		 * methods of immutable class have to return a new instance.
		 */
		public Complex add(Complex c) {
			return new Complex(re + c.re, im + c.im);
		}
		
		/*
		 * public static factory method provides the instance.
		 */
		public static Complex valueOf(double re, double im) {
			return new Complex(re, im);
		}
		
		public double realPart() {return re;}
		public double imaginaryPart() {return im;}
		
		@Override public boolean equals(Object o) {
			if(o == this) return true;
			if(!(o instanceof Complex)) return false;
			
			Complex c = (Complex) o;
			return Double.compare(re, c.re) == 0 && Double.compare(im, c.im) == 0;
		}
		
		@Override public int hashCode() {
			int result = 17 + hashDouble(re);
			result = 31 * result + hashDouble(im);
			return result;
		}
		
		private int hashDouble(double val) {
			long longBits = Double.doubleToLongBits(val);
			return (int) (longBits ^ (longBits >>> 32));
		}
		
		@Override public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.setLength(0);
			sb.append("(").append(re).append(" + ").append(im).append("i)");
			return sb.toString();
		}
	}
}
