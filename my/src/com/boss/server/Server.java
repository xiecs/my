package com.boss.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟BOSS的IO客户端
 * 
 * @author xiecs
 * 
 */
public class Server extends Thread {

	private ServerSocket serverSocket;

	public Server() {
		try {
			serverSocket = new ServerSocket(8888);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			super.run();
			System.out.println("服务端启动......");
			while (true) {
				Socket socket = serverSocket.accept();
				if (socket != null) {
					Client client = new Client(socket);
					client.start();
				} else {
					Server.sleep(1000);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private class Client extends Thread {
		Socket socket;

		DataInputStream inputStream;

		DataOutputStream outputStream;

		public Client(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				super.run();
				inputStream = new DataInputStream(socket.getInputStream());
				outputStream = new DataOutputStream(socket.getOutputStream());

				while (true) {
					if (inputStream.available() <= 0) {
						Thread.sleep(10);
					} else {
						// 读取 报文
						int functionId = readInt(inputStream);
						int length = readInt(inputStream);
						int messageId = readInt(inputStream);

						String info = "";
						if (length > 0) {
							byte[] content = new byte[length];
							inputStream.read(content, 0, length);
							info = new String(content, "GBK");
						}

						System.out.println("服务器接收报文<------------：funId:" + functionId + ",length:" + length + ",mesId:"
								+ messageId + ",content:" + info + ".");
						// String result = "RETC=0&DESC=成功！";
						String result = "";

						// Thread.sleep(5000);

						try {
							if (functionId == 2) {
								continue;
							} else if (functionId == 1) {
								result = succ();
								// result = "RETC=99&DESC=错误!";
							} else if (functionId == 3) {
								//Thread.sleep(1000000);
								result = succ();
							} else if (functionId == 2410) {
								result = succ();
							} else if (functionId == 2411) {
								result = succ();
							}
						} catch (Exception e) {
							result = "RETC=100&DESC=" + e.getMessage();
						}

						byte[] b = result.getBytes("GBK");
						writeInt(outputStream, functionId);
						writeInt(outputStream, b.length);
						writeInt(outputStream, messageId);

						outputStream.write(b);
						System.out.println("服务器发送报文------------>：funId:" + functionId + ",length:" + b.length
								+ ",mesId:" + messageId + ",content:" + result + ".");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				// System.out.println(e);
			}

		}
	}

	private String succ() {
		return "RETC=0&DESC=成功！";
	}

	/**
	 * 写Int
	 * 
	 * @param n
	 * @return
	 * @throws IOException
	 */
	public void writeInt(DataOutputStream out, int n) throws IOException {
		byte[] b = new byte[4];
		// b[0] = (byte) (n & 0xff);
		// b[1] = (byte) (n >>> 8 & 0xff);
		// b[2] = (byte) (n >>> 16 & 0xff);
		// b[3] = (byte) (n >>> 24 & 0xff);
		b[3] = (byte) (n & 0xff);
		b[2] = (byte) (n >>> 8 & 0xff);
		b[1] = (byte) (n >>> 16 & 0xff);
		b[0] = (byte) (n >>> 24 & 0xff);
		out.write(b);
	}

	/**
	 * 读Int
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public int readInt(DataInputStream in) throws IOException {
		int ch1 = in.read();
		int ch2 = in.read();
		int ch3 = in.read();
		int ch4 = in.read();

		if ((ch1 | ch2 | ch3 | ch4) < 0)
			throw new EOFException();
		// return ((ch4 << 24) + (ch3 << 16) + (ch2 << 8) + (ch1 << 0));
		return ((ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4 << 0));
	}

}
