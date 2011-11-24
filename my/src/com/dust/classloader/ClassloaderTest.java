package com.dust.classloader;


import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassloaderTest {


	public static void main(String[] args) throws Exception {
		File file = new File("D://mpay//my//bin//TT.class");
		System.out.println(file.getName());
		URL url = file.toURI().toURL();
		URL[] array = new URL[1];
		array[0] = url;
		ClassLoader loader = new URLClassLoader(array);
		Class clazz = loader.loadClass("TT");

		System.out.println(clazz.getName());

		System.out.println(clazz.getDeclaredField("cc").get(clazz.newInstance()));
		
		
//		Method method = clazz.getMethod("aa", null);
//		method.invoke(clazz.newInstance(), null);

	}

}
