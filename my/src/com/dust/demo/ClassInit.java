package com.dust.demo;

//这不是内部类，会单独生成一个class
class ParentInit {

	private int i = 9;
	protected int j;

	ParentInit() {
		System.out.println("i=" + i + "   j=" + j);
		j = 39;
	}

	private static int x1 = printInit("static ParentInit.x1 initialized");

	static int printInit(String s) {
		System.out.println(s);
		return 47;
	}
}

public class ClassInit extends ParentInit {
	private int k = printInit("ClassInit.k initialized");

	private static int i;

	public ClassInit() {
		// 构造函数在生成对象时执行
		System.out.println(" k = " + k);
		System.out.println(" j = " + j);
		i = 1111111111;
		System.out.println(" i = " + i);
	}

	private static int x2 = printInit("static ClassInit.x2 initialized");

	static {
		// 加载class时执行，只会执行一次
		System.out.println(" i = " + i);
		System.out.println("ClassInit static block");
	}

	public static void main(String[] args) {
		System.out.println("这里是入口");

		System.out.println(ClassInit.x2);

		ClassInit init = new ClassInit();

		// 加载->链接(为静态变量分配内存)->初始化

		// static代码块在加载时就被初始化，而非到创建实例的时候
		// 创建实例，就是new个对象，分配内存地址

		// 所有的static对象和static代码段都会在加载时程序中的顺序而依次被初始化，且只会被初始化一次

		// 对象是在new的时候，才进行初始化

		// 访问类的静态变量会导致类被初始化

	}

}
