package com.monitor;

public class CheckThread extends Thread {

	private Address s;

	public CheckThread(Address s) {
		this.s = s;

	}

	public void run() {
		int i = 0;
		while (true) {
			if (s.getFlag() == Address.SUCC) {
				break;
			} else {
				i++;
				if (i % 2 == 0 && s.getFlag() == Address.INIT) {
					if (s.getType() == Address.HTTP_TYPE) {
						System.out.println(s.getUrl() + " ->未返回响应，继续等待");
					} else if (s.getType() == Address.SOCKET_TYPE) {
						System.out.println(s.getIp() + ":" + s.getPort() + " ->未返回响应，继续等待");
					}
				}
				try {
					Thread.sleep(2000L);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

}
