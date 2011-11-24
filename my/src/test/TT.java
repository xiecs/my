package test;

public class TT {
	
	private static int d= 1;
	
	public int cc;
	
	public static void aa(){
		d++;
		System.out.println("this static method d==" + d);
	}
	
	public TT(){
		d++;
		System.out.println("我是构造函数。。。。d==" + d+cc);
	}
	

	static{
		System.out.println("static block");
	}

}
