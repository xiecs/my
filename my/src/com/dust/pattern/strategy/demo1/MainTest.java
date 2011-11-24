package com.dust.pattern.strategy.demo1;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JiSuanContext context = new JiSuanContext(new JiaFa(111, 222));

		System.out.println(context.getResult());
	}

}
