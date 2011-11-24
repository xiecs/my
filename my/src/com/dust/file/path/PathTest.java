package com.dust.file.path;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class PathTest {

	public static void main(String[] args) throws URISyntaxException {

		// 得到的是当前类PathTest.class文件的URI目录。不包括自己
		System.out.println(PathTest.class.getResource(""));

		// 得到的是当前的classpath的绝对URI路径。
		System.out.println(PathTest.class.getResource("/"));
		
		System.out.println(PathTest.class.getResource("/").getFile());

		// 当前ClassPath的绝对URI路径
		System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));

		// 服务器相对路径
		System.out.println(System.getProperty("user.dir"));

		File f = new File(PathTest.class.getResource("").toURI());
		System.out.println(f.getName());

		URI uri = PathTest.class.getResource("").toURI();
		System.out.println("==================");
		System.out.println("Authority = " + uri.getAuthority());
		System.out.println("Fragment = " + uri.getFragment());
		System.out.println("Host = " + uri.getHost());
		System.out.println("Path = " + uri.getPath());
		System.out.println("Port = " + uri.getPort());
		System.out.println("Query = " + uri.getQuery());
		System.out.println("Scheme = " + uri.getScheme());
		System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
		System.out.println("User Info = " + uri.getUserInfo());
		System.out.println("URI is absolute: " + uri.isAbsolute());
		System.out.println("URI is opaque: " + uri.isOpaque());

		URL url = PathTest.class.getResource("");
		System.out.println("==================");
		System.out.println("Authority = " + url.getAuthority());
		System.out.println("Default port = " + url.getDefaultPort());
		System.out.println("File = " + url.getFile());
		System.out.println("Host = " + url.getHost());
		System.out.println("Path = " + url.getPath());
		System.out.println("Port = " + url.getPort());
		System.out.println("Protocol = " + url.getProtocol());
		System.out.println("Query = " + url.getQuery());
		System.out.println("Ref = " + url.getRef());
		System.out.println("User Info = " + url.getUserInfo());
	}

}
