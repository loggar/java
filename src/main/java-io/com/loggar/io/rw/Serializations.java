package com.loggar.io.rw;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.jupiter.api.Test;

public class Serializations {
	@Test
	public void serialize() throws FileNotFoundException, IOException {
		Player player = new Player("Logg", 35);

		ObjectOutputStream oStream = new ObjectOutputStream(new FileOutputStream("./dist/io/PlayerDat.ser"));
		oStream.writeObject(player);
		oStream.close();
	}

	@Test
	public void deserialize() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream iStream = new ObjectInputStream(new FileInputStream("./dist/io/PlayerDat.ser"));
		Player p = (Player) iStream.readObject();
		
		System.out.println(p);
		
		iStream.close();
	}
}
