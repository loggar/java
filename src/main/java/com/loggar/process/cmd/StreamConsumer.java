package com.loggar.process.cmd;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.Consumer;

// Input and Output
// we need a way to hook into the input and output streams of our process.
// At least the input must be consumed – otherwise our process doesn't return successfully, instead it will hang.
public class StreamConsumer implements Runnable {
	private InputStream inputStream;
	private Consumer<String> consumer;

	public StreamConsumer(InputStream inputStream, Consumer<String> consumer) {
		this.inputStream = inputStream;
		this.consumer = consumer;
	}

	@Override
	public void run() {
		new BufferedReader(new InputStreamReader(inputStream)).lines().forEach(consumer);
	}
}