package com.loggar.io.rw;

import java.io.IOException;

import org.junit.Test;

public class StandardStreams {
	@Test
	public void standardStreams() throws IOException {
		byte teamName[] = new byte[200];
		System.out.print("input team name");
		int size = System.in.read(teamName);
		System.out.write(teamName,0,size);
		
		System.out.println("Team complete");
		System.err.println("Not enough players");
	}
}
