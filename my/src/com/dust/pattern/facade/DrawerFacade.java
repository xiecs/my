package com.dust.pattern.facade;

class DrawerFacade {
	DrawerOne darwerOne = new DrawerOne();
	DrawerTwo darwerTwo = new DrawerTwo();

	public void open() {
		darwerOne.open();
		darwerTwo.open();
	}

}
