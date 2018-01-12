package com.loggar.socket.demo;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 55286);
		OutputStreamWriter os = new OutputStreamWriter(socket.getOutputStream());
		os.write("Santosh Karna");
		os.flush();
		socket.close();
	}
}
