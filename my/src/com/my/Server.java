package com.my;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Server {
	private final Log logger = LogFactory.getLog(getClass());

	private String host;
	private int port;
	private SocketChannel sc;

	public Server(String host, int port) throws IOException {
		this.host = host;
		this.port = port;

	}

	public void run() {
		while (true) {
			try {
				logger.info("连接服务器->" + host + ":" + port);
				InetSocketAddress addr = new InetSocketAddress(host, port);
				sc = SocketChannel.open();
				sc.configureBlocking(false);
				sc.connect(addr);
				if (sc.finishConnect()) {
					// 进行业务逻辑处理
					// ByteBuffer buffer = ByteBuffer.allocate(100);
					

				} else {
					

				}
			} catch (IOException e) {
				logger.info("连接失败，在准备重连");
				try {
					Thread.sleep(5000L);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	/**
	 * 读线程
	 * @author xiecs
	 *
	 */
	private class readThread extends Thread {
		private SocketChannel sc;

		public readThread(SocketChannel sc) {
			this.sc = sc;

		}

		@Override
		public void run() {
			ByteBuffer buffer = ByteBuffer.allocate(100);
			try {
				int b = sc.read(buffer);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	
	/**
	 * 写线程
	 * @author xiecs
	 *
	 */
	private class writeThread extends Thread {
		@Override
		public void run() {

		}
	}

	private void login() {

	}

}
