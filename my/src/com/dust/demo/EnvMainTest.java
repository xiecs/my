package com.dust.demo;

import java.util.Iterator;
import java.util.Map;

public class EnvMainTest {

	public static void main(String[] args) {
		// 获取系统参数并打印显示
		Map<String, String> env = System.getenv();

		System.out.println(env.toString());
		System.out.println("=============");
		Iterator<?> it = env.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			System.out.println("key= " + entry.getKey() + " , value= " + entry.getValue());
		}
	}

}
