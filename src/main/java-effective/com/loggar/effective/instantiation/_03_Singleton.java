package com.loggar.effective.instantiation;

/**
 * Consider Factory Method or Enum class to create Singleton object.
 *
 */
public class _03_Singleton {
	public static void main(String[] args) {
		Sample_1 sample_1_1 = Sample_1.getInstance();
		Sample_1 sample_1_2 = Sample_1.getInstance();
		
		System.out.println(sample_1_1 == sample_1_2);
		System.out.println(sample_1_1.getData());
		
		Sample_2 sample_2_1 = Sample_2.INSTANCE;
		System.out.println(sample_2_1.getData());
	}
	
	static final class Sample_1 {
		private static final Sample_1 INSTANCE = new Sample_1();
		
		private final String data;
		
		private Sample_1() {
			data = "something";
		}
		
		public static synchronized Sample_1 getInstance() {
			return INSTANCE;
		}
		
		public String getData() {
			return data;
		}
	}
	
	public enum Sample_2 {
		INSTANCE;
		
		private final String data;
		
		private Sample_2() {
			data = "something";
		}
		
		public String getData() {
			return data;
		}
	}
}
