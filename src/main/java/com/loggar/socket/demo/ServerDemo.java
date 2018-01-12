package com.loggar.socket.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
	public static void main(String[] args) throws IOException {
		System.out.println("server is started");
		ServerSocket serverSocket = new ServerSocket(55286);
		System.out.println("server is waiting");
		Socket socket = serverSocket.accept();
		System.out.println("Client connected");
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String str = reader.readLine();
		System.out.println("Client data: " + str);
		socket.close();
		serverSocket.close();
	}
}
