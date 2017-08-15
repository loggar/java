package com.loggar.test;

import java.net.UnknownHostException;

public class HostInfo {
	public static void main(String [] args) throws UnknownHostException {
		System.out.println(java.net.InetAddress.getLocalHost().getHostAddress());
	}
}
