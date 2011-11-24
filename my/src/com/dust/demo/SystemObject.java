package com.dust.demo;

public class SystemObject {

	public static void main(String[] args) {

		//======用来读取针对 JVM 的属性=======
		String osName = System.getProperty("os.name");
		String user = System.getProperty("user.name");
		System.out.println("当前操作系统是：" + osName);
		System.out.println("当前用户是：" + user);
		//系统文件编码
		System.out.println(System.getProperty("file.encoding"));
		//User's current working directory,程序运行的当前路径
		System.out.println(System.getProperty("user.dir"));
		
		
		
		//=======获取JAVA_HOME环境变量：
		System.out.println("JAVA_HOME = " + System.getenv("JAVA_HOME") );

	}
}
