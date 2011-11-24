package com.dust.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrivateMain {

	public static void main(String[] args) throws SecurityException, NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		PrivateTest t = new PrivateTest();

		Class<?> clazz = t.getClass();

		Method m = clazz.getDeclaredMethod("privateMethod", new Class[] { String.class });
		m.setAccessible(true);
		m.invoke(t, new Object[] { "hello" });

	}
}
