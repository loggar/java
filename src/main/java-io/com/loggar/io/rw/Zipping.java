package com.loggar.io.rw;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.junit.Test;

public class Zipping {
//	@Test
	public void zipping() throws IOException {
		ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream("./dist/io/out.zip"));
		String[] fNames = new String[] { "./dist/io/f1", "./dist/io/f2" };
		
		for (int i = 0; i < fNames.length; i++) {
			ZipEntry entry = new ZipEntry(fNames[i]);
			InputStream fin = new FileInputStream(fNames[i]);
			try {
				zipOut.putNextEntry(entry);
				for (int a = fin.read(); a != -1; a = fin.read()) {
					zipOut.write(a);
				}
				fin.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		zipOut.close();
	}
	
	@Test
	public void unzipping() throws IOException {
		ZipInputStream zipIn = new ZipInputStream(new FileInputStream("./dist/io/out.zip"));
		
		ZipEntry entry = null;
		while((entry = zipIn.getNextEntry()) != null) {
			System.out.println(entry.getName());
		}
		
		zipIn.close();
	}
}
