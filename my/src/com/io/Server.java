package com.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.io.message.BaseRequest;
import com.io.message.BaseResponse;
import com.io.message.LoginRequest;
import com.io.message.LoginResponse;
import com.io.service.BossContent;
import com.io.util.IOUtils;

public class Server {
	protected static Log logger = LogFactory.getLog(Server.class);

	private int port = 7892;
	private String ip = "10.8.1.166";

	private DataInputStream inputStream;
	private DataOutputStream outputStream;
	private BossContent bossContent;

	public Server(int port, String ip) {
		this.port = port;
		this.ip = ip;
		bossContent = BossContent.getSingleton();
	}

	private void login() throws Exception {
		int messageId = IOUtils.getSecquenceNext();
		LoginRequest request = new LoginRequest();
		request.setFunctionId(1);
		request.setMessageId(messageId);
		request.setPass("pass");
		request.setUser("user");
		LoginResponse response = new LoginResponse();

		bossContent.addRequest(request, response);

		// response = (LoginResponse) bossContent.getResponse(messageId);

	}

	private void logout() {

	}

	private void heart() {

	}

	public void run() throws Exception {
		try {
			Socket socket = new Socket(ip, port);
			System.out.println("连接 " + ip + "：" + port);
			inputStream = new DataInputStream(socket.getInputStream());
			outputStream = new DataOutputStream(socket.getOutputStream());

			while (true) {
				if (socket.isConnected()) {
					Sender sender = new Sender();
					sender.start();
					Receiver receiver = new Receiver();
					receiver.start();
					try {
						System.out.println("login..........");
						login();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				} else {
					try {
						Thread.sleep(1000L);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			inputStream.close();
			outputStream.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 发送报文
	 * 
	 */
	protected class Sender extends Thread {
		@Override
		public void run() {
			System.out.println("发送线程启动");
			while (true) {
				try {
					BaseRequest request = bossContent.getRequest();
					System.out.println(ToStringBuilder.reflectionToString(request));
					if (request == null) {
						Thread.sleep(1000L);
					} else {
						byte[] content = request.getIOMessage();
						byte[] head = new byte[12];
						byte[] funId = writeInt(request.getFunctionId());
						byte[] length = writeInt(content.length);
						byte[] mesId = writeInt(request.getMessageId());
						// src - 源数组。
						// srcPos - 源数组中的起始位置。
						// dest - 目标数组。
						// destPos - 目标数据中的起始位置。
						// length - 要复制的数组元素的数量。
						System.arraycopy(funId, 0, head, 0, 4);
						System.arraycopy(length, 0, head, 4, 4);
						System.arraycopy(mesId, 0, head, 8, 4);
						outputStream.write(head);
						if (content.length > 0)
							outputStream.write(content);
						outputStream.flush();
						logger.info("发送报文：funId=" + request.getFunctionId() + ",length=" + content.length + ",mesId="
								+ request.getMessageId() + ",content=" + new String(content, IOUtils.charset));
					}
				} catch (Exception e) {
					e.printStackTrace();

				}
			}
		}
	}

	/**
	 * 接收报文
	 * 
	 */
	protected class Receiver extends Thread {
		@Override
		public void run() {
			System.out.println("接收线程启动");
			while (true) {
				try {
					if (inputStream.available() > 0) {
						// 读不到数据会一直在等待，阻塞读
						int functionId = inputStream.readInt();
						int length = inputStream.readInt();
						int messageId = inputStream.readInt();

						byte[] content;
						if (length > 0 && length < 10000) {
							content = new byte[length];
							inputStream.read(content, 0, length);
						} else if (length == 0) {
							content = new byte[0];
						} else {
							content = new byte[0];
							throw new Exception("接收的报文太长");
						}
						logger.info("接收报文：funId=" + functionId + ",length=" + length + ",mesId=" + messageId
								+ ",content=" + new String(content, IOUtils.charset));

						BaseResponse response = bossContent.getHasResponse(messageId);
						response.setIOMessage(content);
						response.setFunctionId(functionId);
						response.setMessageId(messageId);
						bossContent.setResponse(response.getMessageId(), response);
					} else {
						Thread.sleep(2000L);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 写Int
	 * 
	 * @param n
	 * @return
	 * @throws IOException
	 */
	public byte[] writeInt(int n) throws IOException {
		byte[] b = new byte[4];
		b[3] = (byte) (n & 0xff);
		b[2] = (byte) (n >>> 8 & 0xff);
		b[1] = (byte) (n >>> 16 & 0xff);
		b[0] = (byte) (n >>> 24 & 0xff);
		return b;
	}

}
