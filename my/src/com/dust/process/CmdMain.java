package com.dust.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CmdMain {

	public static void main(String[] args) throws IOException {
		String command = "ping 127.0.0.1";
		Process process = Runtime.getRuntime().exec(command);
		InputStream is = process.getInputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(is, "GBK"));
		String buff = "";
		StringBuffer sb = new StringBuffer();
		while ((buff = in.readLine()) != null) {
			sb.append(buff);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
