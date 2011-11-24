package com.dust.collection;

import java.util.HashSet;

class B {
	public B(int id) {
		this.id = id;
	}

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// 在同一对象上多次调用 hashCode 方法时，必须一致地返回相同的整数，前提是对象上 equals 比较中所用的信息没有被修改。
	// 从某一应用程序的一次执行到同一应用程序的另一次执行，该整数无需保持一致。

	// 如果不重写，就算内容没变，不同对象返回不一样的hashcode

	@Override
	public int hashCode() {
		return this.id;
	}

	// 注意：当此方法被重写时，通常有必要重写 hashCode 方法，以维护 hashCode 方法的常规协定，该协定声明相等对象必须具有相等的哈希码。

	// 如果根据 equals(Object) 方法，两个对象是相等的，
	// 那么在两个对象中的每个对象上调用 hashCode 方法都必须生成相同的整数结果。
	// 这个是规范约定，如果不遵守不会报错，只是影响性能。

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof B) {
			B b = (B) obj;
			if (b.id == this.id)
				return true;
			else
				return false;
		} else
			return false;
	}

}

public class HashTest {

	public static void main(String[] args) {
		B b1 = new B(11);
		B b2 = new B(11);

		System.out.println(b1.hashCode());
		System.out.println(b2.hashCode());

		System.out.println(b1.equals(b2));

		// 会调用hashcode方法进行比较
		HashSet<B> set = new HashSet<B>();
		set.add(b1);
		set.add(b2);
		System.out.println(set.size());

	}

}
