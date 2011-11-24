package com.my;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;

public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		PropertyConfigurator.configure("D://workcode//my//src//com//my//log4j.properties");
		Server s = new Server("127.0.0.1", 8888);
		s.run();

	}

}
