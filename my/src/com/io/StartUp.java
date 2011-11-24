package com.io;

public class StartUp {

	public static void main(String[] args) throws Exception {

		// Server server = new Server(7897, "10.8.1.166");

		Server server = new Server(7892, "127.0.0.1");

		server.run();

	}

}
