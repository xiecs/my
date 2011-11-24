package com.dust.classloader.lock;

import java.net.URL;
import java.net.URLClassLoader;

public class MyClassLoader1 extends URLClassLoader {
	MyClassLoader1(URL[] urls) {
		super(urls);
	}

	public Class<?> loadClass(String name) throws ClassNotFoundException {
		if (name.startsWith("com.dust.classloader.lock.package2"))
			return MyClassLoader2.getClassLoader().loadClass(name);
		else
			return findClass(name);
	}
}
