package com.loggar.effective.instantiation;

/**
 * Prefer Static Factory Method than Constructor.
 * 
 */
public class _01_StaticFactoryMethod {
	static class StaticFactoryMethodSample {
		private String field_01;
		
		private StaticFactoryMethodSample() {
			this.field_01 = "default value";
		}
		
		private StaticFactoryMethodSample(String data) {
			this.field_01 = data;
		}
		
		public String getValue() {
			return this.field_01;
		}
		
		/**
		 * provide an instance from its data.
		 * @param data
		 * @return
		 */
		public static StaticFactoryMethodSample valueOf(String data) {
			return new StaticFactoryMethodSample(data);
		}
		
		/**
		 * a concise alternative to valueOf
		 * @param data
		 * @return
		 */
		public static StaticFactoryMethodSample of(String data) {
			return new StaticFactoryMethodSample(data);
		}
		
		/**
		 * provide an instance of this class.
		 * In the case of a singleton, it takes no parameters and returns the sole instance.
		 * @param data
		 * @return
		 */
		public static synchronized StaticFactoryMethodSample getInstance(String data) {
			return new StaticFactoryMethodSample(data);
		}
		
		/**
		 * provide an instance of this class, guarantees that each instance returned is distinct from all others.
		 * @return
		 */
		public static StaticFactoryMethodSample newInstance(String data) {
			return new StaticFactoryMethodSample(data);
		}
	}
	
	static class StaticFactoryMethodSampleMaker {
		/**
		 * like getInstance, but used when the factory method is in a different class.
		 * @param data
		 * @return
		 */
		public static StaticFactoryMethodSample getType(String data) {
			return StaticFactoryMethodSample.getInstance(data);
		}
		
		/**
		 * like newInstance, but used when the factory method is in a different class.
		 * @param data
		 * @return
		 */
		public static StaticFactoryMethodSample newType(String data) {
			return StaticFactoryMethodSample.newInstance(data);
		}
	}
}
