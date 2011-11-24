package com.dust.demo;

public class StringTest {

	public static void main(String[] args) {

		// 其实只要理解字符串常量池，字符串不可变，JDK编译优化机制就能够知道正确答案了
		String a = "abc";
		String b = "abc";
		String ab = "ab";
		String c = ab + "c";
		String d = "ab" + "c";
		String o = new String("abc");

		System.out.println("a hashcode: " + a.hashCode());
		System.out.println("b hashcode: " + b.hashCode());
		System.out.println("c hashcode: " + c.hashCode());
		System.out.println("d hashcode: " + d.hashCode());
		System.out.println("o hashcode: " + o.hashCode());

		System.out.println(a == b);
		System.out.println(a == c);
		System.out.println(a == d);

		System.out.println(a == o);
		System.out.println(c == o);
	}

}
