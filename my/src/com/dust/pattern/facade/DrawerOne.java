package com.dust.pattern.facade;


/**
 * 子系统1
 * @author xiecs
 *
 */
class DrawerOne {

	public void open() {
		System.out.println("第一个抽屉被打开了");
		getKey();
	}

	public void getKey() {
		System.out.println("得到第二个抽屉的钥匙");
	}

}
