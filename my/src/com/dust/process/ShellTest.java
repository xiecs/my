package com.dust.process;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;

public class ShellTest {

	public static void main(String[] args) throws Exception {

		ProcessBuilder builder = new ProcessBuilder("cmd", "d:", "dir");

		// 获取系统参数并打印显示
		Map<String, String> env = builder.environment();
		System.out.println(env);

		// builder.directory(new File("e:/"));
		Process process = builder.start();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
		// '\r\n'是必须写入的，表示命令结束
		// bw.write("ping -t www.yahoo.com.cn \r\n");
		bw.write("dir \r\n");
		// flush()方法是必须调用的，清空缓冲区
		bw.flush();

		BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
		String s;
		while ((s = results.readLine()) != null) {
			System.out.println(s);
		}
		// proc.waitFor();
	}
}
