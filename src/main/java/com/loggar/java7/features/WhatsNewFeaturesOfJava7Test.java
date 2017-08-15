package com.loggar.java7.features;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class WhatsNewFeaturesOfJava7Test {
	
	/*
	 * now we can use String in switch statements.
	 */
	@Test
	public void stringInSwitch() {
		String s = "a";
		
		switch (s) {
		case "a": System.out.println(s);
			break;
		default:
			break;
		}
	}
	
	/*
	 * now we can use single catch statement for throwing multiple exception by using "|" operator.
	 * 
	 */
	@Test
	public void multiExceptionSingleCatchStatement() throws Exception {
		String path = "./dist/io/test.txt";
		
		try {
			FileReader fr = new FileReader(path);
			System.out.println(fr);
		} catch(IOException | NullPointerException ex) {
			throw ex;
		}
	}
	
	/*
	 * now we can use underscores in numeric literals.
	 */
	@Test
	public void underscoresInNumericLiterals() {
		long phoneNo = 99_99_9999999L;
		long securityNo = 999_99_9999L;
		float pi = 3.14_15F;
		int val = 12_15;
		
		System.out.println(phoneNo);
		System.out.println(securityNo);
		System.out.println(pi);
		System.out.println(val);
	}
	
	/*
	 * use simple "<>" for generic instance creation.
	 */
	@Test
	public void genericCreationSimple() {
		Map<String, Object> map1 = new HashMap<>();
		Map<String, List<String>> map2 = new HashMap<>();
		
		System.out.println(map1);
		System.out.println(map2);
	}
	
	/*
	 * no need to close() resource because Java7 provides the try-with-resources statement.
	 */
	@Test
	public void noNeedCloseResource() {
		String path = this.getClass().getResource("").getPath();
		String s = "./test.txt";
		
		InputStream is = null;
		
		try {
			is = new FileInputStream(path+s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(is));
			BufferedReader br2 = new BufferedReader(new InputStreamReader(is))
		) {
			String name = br.readLine();
			System.out.println(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
