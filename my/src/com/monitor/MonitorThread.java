package com.monitor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

public class MonitorThread extends Thread {
	private String url;
	private Address s;

	public MonitorThread(Address s) {
		this.s = s;
		this.url = s.getUrl();
	}

	public void run() {
		if (s.getType() == Address.HTTP_TYPE) {
			scanHttp();

		} else if (s.getType() == Address.SOCKET_TYPE) {
			scanSocket();
		}

	}

	private void scanSocket() {
		InetSocketAddress addr = new InetSocketAddress(s.getIp(), s.getPort());

		try {
			SocketChannel sc = SocketChannel.open();
			sc = SocketChannel.open();
			//sc.configureBlocking(false); 这个需要服务端支持？？
			System.out.println("发起->" + s.getIp() + ":" + s.getPort());
			sc.connect(addr);
			if (sc.finishConnect()) {
				s.setFlag(Address.SUCC);
				System.out.println(s.getIp() + ":" + s.getPort() + "->正常访问.");
			} else {
				s.setFlag(Address.ERROR);
				System.out.println(s.getIp() + ":" + s.getPort() + "->无法正常访问!!!!!!!!!!!!!!!!!!!!");
			}
			
			sc.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void scanHttp() {
		HttpClient client = new HttpClient();
		GetMethod get = new GetMethod(url);
		int status = 0;
		try {
			System.out.println("发起->" + url);
			status = client.executeMethod(get);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			get.releaseConnection();
		}
		if (status != 200) {
			s.setFlag(Address.ERROR);
			System.out.println(url + "->无法正常访问!!!!!!!!!!!!!!!!!!!!");
		} else {
			s.setFlag(Address.SUCC);
			System.out.println(url + ":正常访问.");
		}
	}

}
