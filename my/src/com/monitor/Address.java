package com.monitor;

public class Address {

	private String url;
	private String ip;
	private int port;

	private int type;// 类型，http，socket
	private int flag = Address.INIT;

	public static final int INIT = 0;
	public static final int SUCC = 1;
	public static final int ERROR = 2;

	public static final int HTTP_TYPE = 1;
	public static final int SOCKET_TYPE = 2;

	public Address(String url) {
		super();
		this.url = url;
		this.type = Address.HTTP_TYPE;
	}

	public Address(String ip, int port) {
		super();
		this.ip = ip;
		this.port = port;
		this.type = Address.SOCKET_TYPE;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
