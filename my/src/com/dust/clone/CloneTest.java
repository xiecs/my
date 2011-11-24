package com.dust.clone;

class A extends Object{
	private String aa;

	public String getAa() {
		return aa;
	}

	public void setAa(String aa) {
		this.aa = aa;
	}
	
	
}

public class CloneTest {
	
	public static void main(String[] args) {
		A a1=new A();
		
		System.out.println(a1.getClass().getSimpleName());
		System.out.println(a1.getClass().getName());
		System.out.println(a1.getClass().getClassLoader());
		
	}

}
