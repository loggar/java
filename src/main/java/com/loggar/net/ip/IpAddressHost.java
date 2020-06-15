package com.loggar.net.ip;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class IpAddressHost {
	public static void main(String args[]) throws Exception {
		InetAddress inetAddress = InetAddress.getLocalHost();
		System.out.println("=== host public address ===");
		System.out.println("IP Address:- " + inetAddress.getHostAddress());
		System.out.println("Host Name:- " + inetAddress.getHostName());

		System.out.println("=== host address interfaces ===");
		Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
		while (e.hasMoreElements()) {
			NetworkInterface n = (NetworkInterface) e.nextElement();
			Enumeration<InetAddress> ee = n.getInetAddresses();
			while (ee.hasMoreElements()) {
				InetAddress i = (InetAddress) ee.nextElement();
				System.out.println(i.getHostAddress());
			}
		}

		System.out.println("=== Preferred outbound IP. ===");
		String ip;
		try (final DatagramSocket socket = new DatagramSocket()) {
			// The destination 8.8.8.8 is not needed to be reachable
			socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
			ip = socket.getLocalAddress().getHostAddress();
		}
		System.out.println("Preferred outbound IP:- " + ip);
	}
}
