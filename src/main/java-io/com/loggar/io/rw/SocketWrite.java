package com.loggar.io.rw;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketWrite {
	private final String socketHost = "127.0.0.1";
	private final int socketPort = 64783;

	// @Test
	public void writeCharData() throws IOException {
		Socket socket = new Socket(socketHost, socketPort);
		PrintWriter pWriter = new PrintWriter(socket.getOutputStream());
		pWriter.println("Dad, we won the game.");

		pWriter.close();
		socket.close();
	}

	// @Test
	public void writeBinaryData() throws IOException {
		byte positions[] = new byte[10];
		Socket socket = new Socket(socketHost, socketPort);
		DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
		outStream.write(positions, 0, 10);

		outStream.close();
		socket.close();
	}

	// @Test
	public void writeLargeBinaryData() throws IOException {
		byte positions[] = new byte[10];
		Socket socket = new Socket(socketHost, socketPort);
		DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
		outStream.write(positions, 0, 10);

		outStream.close();
		socket.close();
	}
}
