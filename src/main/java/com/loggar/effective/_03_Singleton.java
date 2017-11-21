package com.loggar.effective;

/**
 * 싱글톤 객체를 만들때는 factory method 나 enum 을 고려하자.
 * @author loggar.lee
 *
 */
public class _03_Singleton {
	public static void main(String[] args) {
		Sample_1 sample_1_1 = Sample_1.getInstance();
		Sample_1 sample_1_2 = Sample_1.getInstance();
		
		System.out.println(sample_1_1 == sample_1_2);
		System.out.println(sample_1_1.getData());
		
		sample_2 sample_2_1 = sample_2.INSTANCE;
		System.out.println(sample_2_1.getData());
	}
	
	static final class Sample_1 {
		private static final Sample_1 INSTANCE = new Sample_1();
		
		private final String data;
		
		private Sample_1() {
			data = "something";
		}
		
		public static Sample_1 getInstance() {
			return INSTANCE;
		}
		
		public String getData() {
			return data;
		}
	}
	
	public enum sample_2 {
		INSTANCE;
		
		private final String data;
		
		private sample_2() {
			data = "something";
		}
		
		public String getData() {
			return data;
		}
	}
}
