package com.loggar.statements;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class TransientSampleTest {
	@Test
	public void test1() throws FileNotFoundException, IOException, ClassNotFoundException {
		TransientSample TransientSample = new TransientSample("Steve", "Middle", "Jobs");
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("./dist/transient/TransientSample"));
		// writing to object
		o.writeObject(TransientSample);
		o.close();

		// reading from object
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("./dist/transient/TransientSample"));
		TransientSample TransientSample1 = (TransientSample) in.readObject();
		System.out.println(TransientSample1);
		in.close();
	}
}
