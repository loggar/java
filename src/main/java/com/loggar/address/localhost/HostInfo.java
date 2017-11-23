package com.loggar.address.localhost;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostInfo {
	public static void main(String[] args) {
		try {
			System.out.println(java.net.InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}

		InetAddress ip;
		String hostname;
		try {
			ip = InetAddress.getLocalHost();
			hostname = ip.getHostName();
			System.out.println("Your current IP address : " + ip);
			System.out.println("Your current Hostname : " + hostname);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
