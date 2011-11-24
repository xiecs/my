package com.dust.pattern.facade;


/**
 * 子系统2
 * @author xiecs
 *
 */
class DrawerTwo {
	public void open() {
		System.out.println("第二个抽屉被打开了");
		getFile();
	}

	public void getFile() {
		System.out.println("得到这个重要文件");
	}

}
