package com.loggar.io.rw;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

public class SocketRead {
	private final String socketHost = "127.0.0.1";
	private final int socketPort = 64783;

	@Test
	public void readCharData() throws UnknownHostException, IOException {
		Socket socket = new Socket(socketHost, socketPort);
		InputStreamReader reader = new InputStreamReader(socket.getInputStream());
		BufferedReader bReader = new BufferedReader(reader);
		String msg = bReader.readLine();

		System.out.println(msg);

		bReader.close();
		reader.close();
		socket.close();
	}

	@Test
	public void readBinaryData() throws IOException {
		Socket socket = new Socket(socketHost, socketPort);
		DataInputStream inStream = new DataInputStream(socket.getInputStream());
		inStream.read();
		System.out.println(inStream);

		inStream.close();
		socket.close();
	}

	@Test
	public void readBinaryLargeData() throws IOException {
		Socket socket = new Socket(socketHost, socketPort);
		DataInputStream inStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		inStream.read();
		System.out.println(inStream);

		inStream.close();
		socket.close();
	}
}
