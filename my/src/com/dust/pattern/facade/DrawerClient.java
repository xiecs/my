package com.dust.pattern.facade;

public class DrawerClient {

	public static void main(String[] args) {
		// Facade模式是这样描述的: 为子系统中的一组接口提供一个统一接口。
		// Facade模式定义了一个更高层的接口，使子系统更加容易使用。
		DrawerFacade drawer = new DrawerFacade();
		drawer.open();
	}

}
