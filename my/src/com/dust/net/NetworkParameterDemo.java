package com.dust.net;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class NetworkParameterDemo {
	public static void main(String[] args) throws Exception {
		Enumeration en = NetworkInterface.getNetworkInterfaces();
		List<String> ipList = new ArrayList();
		while (en.hasMoreElements()) {
			NetworkInterface intf = (NetworkInterface) en.nextElement();
			Enumeration enAddr = intf.getInetAddresses();
			while (enAddr.hasMoreElements()) {
				InetAddress addr = (InetAddress) enAddr.nextElement();
				if (addr instanceof Inet4Address) {
					ipList.add(addr.getHostAddress());
				}
			}
		}
//		SocketException se = null;
//		for (String ip : ipList) {
//			try {
//				Socket s = new Socket(ip, port);
//				s.close();
//				se = new SocketException("Address already in use " + ip);
//				break;
//			} catch (Exception e) {
//				// silence
//			}
//		}
//		if (se != null) {
//			throw se;
//		}

	}

}